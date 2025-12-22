import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int I = 0; I < N; I++) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> counts = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                counts.add(new ArrayList<>());
            }
            for (int i = 0; i < s.length(); i++) {
                counts.get(s.charAt(i) - 'a').add(i);
            }
            check(counts, n);
        }
    }

    static void check(List<List<Integer>> counts, int n) {
        int s = Integer.MAX_VALUE;
        int l = -1;
        for (int i = 0; i < 26; i++) {
            if (counts.get(i).size() < n) continue;
            for (int j = 0; j < counts.get(i).size() - n + 1; j++) {
                int startIdx = counts.get(i).get(j);
                int lastIdx = counts.get(i).get(j + n - 1);
                int gap = lastIdx - startIdx + 1;
                if (s > gap) s = gap;
                if (l < gap) l = gap;
            }
        }
        if (l == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(s + " " + l);
    }
}
