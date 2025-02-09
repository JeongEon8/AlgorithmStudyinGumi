import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check(i, j)) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean check(int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] done = new boolean[N];
        done[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < N; i++) {
                int next = list.get(now).get(i);
                if(next==1){
                    if (i == end) return true;
                    if (!done[i]) {
                        q.add(i);
                        done[i] = true;
                    }
                }
            }
        }

        return false;
    }

}
