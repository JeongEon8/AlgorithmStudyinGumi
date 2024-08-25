import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Kayak implements Comparable<Kayak> {
        int num, startC;

        public Kayak(int num, int startC) {
            this.num = num;
            this.startC = startC;

        }

        @Override
        public int compareTo(Kayak o) {

            return o.startC - this.startC;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");

        int R = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);

        String[] lines = new String[R];

        for (int i = 0; i < R; i++) {
            lines[i] = in.readLine();
        }

        List<Kayak> kList = new ArrayList();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char cur = lines[i].charAt(j);
                if ('1' <= cur && cur <= '9') {
                    kList.add(new Kayak(cur - '0', j));
                    break;
                }
            }
        }

        Collections.sort(kList);
        int[] ranking = new int[10];
        int rank = 1;
        ranking[kList.get(0).num] = rank;
        for (int i = 1; i < 9; i++) {
            if (kList.get(i - 1).startC > kList.get(i).startC)
                rank++;
            ranking[kList.get(i).num] = rank;
        }
        for (int i = 1; i <= 9; i++) {
            System.out.println(ranking[i]);
        }

    }

}