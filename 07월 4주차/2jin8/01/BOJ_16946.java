import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16946 {

    static int N, M;
    static int[][] map, record; // record: 이동 가능한 칸의 개수 저장용
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static HashSet<Integer> used = new HashSet<>();
    static ArrayList<int[]> wallList = new ArrayList<>();
    static ArrayList<int[]> emptyList = new ArrayList<>();
    static HashMap<Integer, Integer> group = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] lines = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = lines[j] - '0'; // 0: 이동할 수 있는 곳, 1: 벽이 있는 곳
                if (map[i][j] == 1) {
                    wallList.add(new int[]{i, j}); // 벽의 위치 기록
                } else {
                    emptyList.add(new int[]{i, j}); // 빈 공간 위치 기록
                }
            }
        }

        // 연결되어 있는 것끼리 묶기 (벽이 없는 공간 기준)
        int groupNumber = 0;
        record = new int[N][M];
        for (int[] pos : emptyList) {
            int x = pos[0], y = pos[1];
            if (!visited[x][y]) {
                int count = makeGroup(x, y, ++groupNumber);
                group.put(groupNumber, count);
            }
        }

        for (int[] pos : wallList) {
            int x = pos[0], y = pos[1];
            used.clear();
            // 주변의 그룹 정보만 확인하면 됨
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 벽이 아닌 공간은 그룹에 속함
                // 해당 그룹 알아낸 후 그룹에 속하는 수 더하기
                if (map[nx][ny] == 0) {
                    int number = record[nx][ny];
                    if (!used.contains(number)) { // 이미 있으면 false
                        map[x][y] += group.get(number);
                        used.add(number);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int makeGroup(int x, int y, int groupNumber) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            record[now[0]][now[1]] = groupNumber;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return count;
    }
}
