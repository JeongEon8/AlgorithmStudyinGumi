import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

    static int N, L, R;
    static int[][] arr, newArr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        newArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) { // 최대 2000번
            visited = new boolean[N][N];
            boolean isMove = false; // 이동 여부
            copyArray(arr, newArr);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        // 연합 찾기
                        isMove |= findUnion(i, j);
                    }
                }
            }
            copyArray(newArr, arr);

            // 이동이 없으면 종료
            if (!isMove) break;

            day++;
        }
        System.out.println(day);
    }

    // 연합 찾기
    static boolean findUnion(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        boolean isMove = false;

        ArrayList<int[]> unionList = new ArrayList<>();
        int totalPeople = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            unionList.add(now);
            totalPeople += arr[now[0]][now[1]];

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                // 현재 칸과의 인구 차이 비교하기
                int diff = Math.abs(arr[now[0]][now[1]] - arr[nx][ny]);
                if (diff >= L && diff <= R) { // 인구 차이가 L명 이상, R명 이하라면 국경선 열기
                    isMove = true;
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        // 인구 이동
        movePeople(unionList, totalPeople);
        return isMove;
    }

    public static void copyArray(int[][] from, int[][] to) {
        for (int i = 0; i < N; i++) {
            to[i] = from[i].clone();
        }
    }

    // 인구 이동
    public static void movePeople(ArrayList<int[]> unionList, int totalPeople) {
        int newPeople = totalPeople / unionList.size();
        for (int[] union : unionList) {
            newArr[union[0]][union[1]] = newPeople;
        }
    }
}
