import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int I = 0; I < N; I++) {
            int[] list = new int[201];
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                list[teamNum]++;
                order.add(teamNum);
            }
            Map<Integer, ArrayList<Integer>> scores = new HashMap<>();
            List<Integer> good = new ArrayList<>();
            for (int i = 1; i < 201; i++) {
                if (list[i] == 6) {
                    scores.put(i, new ArrayList<>());
                    good.add(i);
                }
            }
            int score = 1;
            for (int now : order) {
                if (list[now] == 6) {
                    scores.get(now).add(score);
                    score++;
                }
            }
            int lowScore = Integer.MAX_VALUE;
            int answer = 0;
            for (int i : good) {
                ArrayList<Integer> arrayList = scores.get(i);
                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    sum += arrayList.get(j);
                }
                if (sum < lowScore) {
                    lowScore = sum;
                    answer = i;
                } else if (sum == lowScore) {
                    if (arrayList.get(4) < scores.get(answer).get(4)) {
                        answer = i;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
