import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_4013 {

    static int N = 4, M = 8, K;
    static ArrayList<Integer>[] magnetics = new ArrayList[N + 1]; // 자석 정보를 저장할 리스트
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        Queue<int[]> rotateQueue = new LinkedList<>(); // 회전할 자석들을 저장하기 위한 큐
        boolean[] checked = new boolean[N + 1]; // 자석 탐색 여부를 위한 배열
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine()); // 회전 횟수
            for (int i = 0; i <= N; i++) {
                magnetics[i] = new ArrayList<>();
            }

            // 자석 정보 저장하기
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    magnetics[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            // 자석 회전하기
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int target = Integer.parseInt(st.nextToken()); // 회전할 자석
                int direction = Integer.parseInt(st.nextToken()); // 회전 방향

                rotateQueue.clear(); // 회전할 자석들을 저장하기 위한 큐 초기화
                Arrays.fill(checked, false); // 자석 탐색 여부를 위한 배열 초기화

                Queue<Magnetic> queue = new LinkedList<>(); // 회전하는 자석들을 찾기 위한 큐
                queue.offer(new Magnetic(target, magnetics[target].get(2), magnetics[target].get(6), direction));
                checked[target] = true;
                while (!queue.isEmpty()) {
                    Magnetic now = queue.poll();
                    rotateQueue.offer(new int[]{now.idx, now.direction});

                    // 현재 자석의 오른쪽 자석 탐색
                    int next = now.idx + 1;
                    int rotateD = now.direction == 1? -1 : 1;
                    if (next <= N && !checked[next] && now.point1 != magnetics[next].get(6)) {
                        queue.offer(new Magnetic(next, magnetics[next].get(2), magnetics[next].get(6), rotateD));
                        checked[next] = true;
                    }

                    // 현재 자석의 왼쪽 자석 탐색
                    next = now.idx - 1;
                    if (next >= 1 && !checked[next] && now.point2 != magnetics[next].get(2)) {
                        queue.offer(new Magnetic(next, magnetics[next].get(2), magnetics[next].get(6), rotateD));
                        checked[next] = true;
                    }
                }

                // 회전 가능한 자석들 회전시키기
                while (!rotateQueue.isEmpty()) {
                    int[] now = rotateQueue.poll(); // 0: 타겟, 1: 이동 방향
                    int moveTarget = now[0];
                    if (now[1] == 1) { // 시계 방향으로 회전하는 경우
                        // 제일 뒤에 것을 제일 앞으로 이동
                        magnetics[moveTarget].add(0, magnetics[moveTarget].remove(M - 1));
                    }
                    else { // 반시계 방향으로 회전하는 경우
                        // 앞에 것을 제일 뒤로 이동
                        magnetics[moveTarget].add(magnetics[moveTarget].remove(0));
                    }
                }
            }

            // 회전이 끝난 후 점수 세기
            int score = 0;
            for (int i = 1; i <= N; i++) {
                // 화살표가 가리키는 곳이 N극이면 점수를 얻음
                if (magnetics[i].get(0) == 1) {
                    score += (int) Math.pow(2, i - 1);
                }
            }
            sb.append("#").append(t).append(" ").append(score).append("\n");
        }
        System.out.println(sb);
    }

    static class Magnetic {
        int idx; // 위치 (인덱스)
        int point1, point2; // 2번, 6번의 값
        int direction; // 회전 방향

        public Magnetic(int idx, int point1, int point2, int direction) {
            this.idx = idx;
            this.point1 = point1;
            this.point2 = point2;
            this.direction = direction;
        }
    }
}
