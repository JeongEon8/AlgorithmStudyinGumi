import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Bucket[][] arr = new Bucket[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = new Bucket(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        int[][] moves = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            moves[i][0] = Integer.parseInt(st.nextToken()) - 1;
            moves[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        Queue<Bucket> before = new LinkedList<>();
        before.add(arr[N - 1][0]);
        before.add(arr[N - 1][1]);
        before.add(arr[N - 2][0]);
        before.add(arr[N - 2][1]);

        for (int m = 0; m < M; m++) {
            Queue<Bucket> queue = new LinkedList<>();
            ArrayList<Point> cloud = new ArrayList<>();
            while (before.size() != 0) {
                Bucket n = before.poll();

                int row = n.x + (dx[moves[m][0]] * moves[m][1]);
                int col = n.y + (dy[moves[m][0]] * moves[m][1]); // 1번 : 구름 이동하기

                while (row > N - 1) {
                    row -= N ;
                }
                while (row < 0) {
                    row += N;
                }

                while (col > N - 1) {
                    col -= N;
                }
                while (col < 0) {
                    col += N;
                }
                arr[row][col].waters += 1; // 구름이 있는 위치에다가 +1
                queue.add(arr[row][col]);
                cloud.add(new Point(row,col));
            }

            int[] rx = {-1, -1, 1, 1};
            int[] ry = {-1, 1, -1, 1};

            while (queue.size() != 0) {
                Bucket n = queue.poll();
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = n.x + rx[i];
                    int ny = n.y + ry[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (arr[nx][ny].waters > 0) {
                        cnt += 1;
                    }
                }
                arr[n.x][n.y].waters += cnt;

            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].waters >= 2) {
                        boolean isContain = false;

                        for (int l = 0; l < cloud.size(); l++) {
                          if(cloud.get(l).equals(new Point(i,j))){
                            isContain = true;
                            break;
                          }
                        }

                        if (isContain == false) {
                            arr[i][j].waters -= 2;
                            before.add(arr[i][j]);
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += arr[i][j].waters;
            }
        }
        System.out.println(answer);
    }

    static class Bucket {

        int x;
        int y;
        int waters;

        public Bucket(int x, int y, int waters) {
            this.x = x;
            this.y = y;
            this.waters = waters;
        }

        @Override
        public String toString() {
            return waters+" ";
        }
    }
}
