import java.util.*;

public class BOJ_18352 {

    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] d = new int[300001]; // 최단거리 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
            d[i] = -1; // 최단거리 -1로 초기화
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
        }

        d[x] = 0; // 시작지점의 최단거리 값 0으로 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if (d[next] == -1) {
                    // 도로의 거리가 1이기 때문에 이전 최단거리에 +1한 값 저장
                    d[next] = d[now] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (check == false)
            System.out.println(-1);
    }
}
