import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        Integer[] list = new Integer[100001];
        for (int i = 0; i < 100001; i++) {
            list[i] = -1;
        }
        Queue<Integer> q = new ArrayDeque<>();
        list[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now * 2 <= 100000) {
                if (list[now * 2] == -1 || list[now * 2] > list[now]) {
                    q.add(now * 2);
                    list[now * 2] = list[now];
                    if (now * 2 == goal) break;
                }
            }
            if (now - 1 >= 0) {
                if (list[now - 1] == -1 || list[now - 1] > list[now] + 1) {
                    q.add(now - 1);
                    list[now - 1] = list[(now)] + 1;
                    if (now - 1 == goal) break;
                }
            }
            if (now + 1 <= 100000) {
                if (list[now + 1] == -1 || list[now + 1] > list[now] + 1) {
                    q.add(now + 1);
                    list[now + 1] = list[now] + 1;
                    if (now + 1 == goal) break;
                }
            }

        }
        System.out.println(list[goal]);
    }
}
