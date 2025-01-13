import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int dir = 0; //동남서북

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a - 1][b - 1] = 1;
        }

        int l = sc.nextInt();
        Map<Integer, Character> dirChange = new HashMap<>();

        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            dirChange.put(x, c);
        }

        System.out.println(playGame(n, dirChange));
    }

    public static int playGame(int n, Map<Integer, Character> dirChange) {
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0}); //뱀의 초기 위치 저장
        map[0][0] = 2; //뱀 위치에 2 저장

        int time = 0;

        while (true) {
            time++;

            //머리 이동
            int[] head = snake.peekFirst();
            int nextX = head[0] + dx[dir];
            int nextY = head[1] + dy[dir];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] == 2) {
                break;
            }

            if (map[nextX][nextY] == 1) {
                //사과가 있다면
                snake.addFirst(new int[]{nextX, nextY});
                map[nextX][nextY] = 2;
                //꼬리는 그대로이므로 따로 값 변경 안 함 
            } else {
                //사과가 없다면
                snake.addFirst(new int[]{nextX, nextY});
                map[nextX][nextY] = 2;

                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0; //꼬리위치는 0 삽입
            }

            //방향 전환
            if (dirChange.containsKey(time)) {
                char turn = dirChange.get(time);
                if (turn == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽
                } else if (turn == 'D') {
                    dir = (dir + 1) % 4; // 오른쪽
                }
            }
        }

        return time;
    }
}
