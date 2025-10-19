import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3190 {

    static int N, K, L;
    static int[][] map, moveInfo;
    static int[] change = new int[10001];
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 이동 규칙
        // 1. 몸 길이 늘림 => 머리를 다음 칸에 위치
        // 2. 벽이나 자기 자신 몸이랑 부딪히면 끝남
        // 3. 이동한 칸에 사과가 있다? 사과 없어짐 & 꼬리는 그대로 == 1칸 앞으로 이동 & 몸 길이 1 증가
        // 4. 이동한 칸에 사과가 없다? 꼬리 칸 없애기 == 1칸 앖으로 이동

        // 구해야 하는 것
        // 사과의 위치와 뱀의 이동경로 주어질 때, "게임이 몇 초에 끝나는지"

        N = Integer.parseInt(br.readLine()); // 보드의 크기
        map = new int[N + 1][N + 1];
        moveInfo = new int[N + 1][N + 1];

        K = Integer.parseInt(br.readLine()); // 사과의 개수
        StringTokenizer st = null;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1; // 사과는 1로 표시
        }

        L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0) == 'L' ? -1 : 1; // L이면 -1, D면 1
            change[x] = d;
        }

        int time = 0, dir = 0;
        int headR = 1, headC = 1, tailR = 1, tailC = 1;
        map[1][1] = 2; // 뱀의 몸은 2로 표시
        while (true) {
            time++;

            // 뱀 머리 이동
            int nextR = headR + dr[dir];
            int nextC = headC + dc[dir];
            // 벽이나 자신의 몸이랑 부딪히면 종료
            if (nextR <= 0 || nextC <= 0 || nextR > N || nextC > N || map[nextR][nextC] == 2)
                break;

            moveInfo[headR][headC] = dir; // 어느 방향으로 이동했는지 기록 (인덱스 에러 주범 - 위치 조심..!)

            // 이동한 칸에 사과가 없는 경우, 꼬리 1칸 없어짐
            if (map[nextR][nextC] == 0) {
                map[tailR][tailC] = 0;
                int tailDir = moveInfo[tailR][tailC];
                tailR += dr[tailDir];
                tailC += dc[tailDir];
            }

            map[nextR][nextC] = 2; // 뱀 머리 이동
            headR = nextR; headC = nextC; // 머리 위치 옮기기

            // 방향 변환 정보가 있는 경우, 방향 전환
            if (change[time] != 0) {
                dir += change[time];
                if (dir < 0) dir = 3;
                if (dir > 3) dir = 0;
            }
        }
        System.out.println(time);
    }
}
