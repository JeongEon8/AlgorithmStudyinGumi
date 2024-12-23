import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4485 {

    static int n;
    static int[][] map;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problemNum = 1;

        while(true){
            n = sc.nextInt();
            if(n==0) break;

            map = new int[n][n];
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }

            int answer = shortest();

            System.out.println("Problem " + problemNum + ": " + answer);
            problemNum++;
        }
    }

    static int shortest() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, map[0][0]}); //시작점 (x, y, 합)
        arr[0][0] = map[0][0];

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int cost = now[2];

            //현재 cost가 이전의 값보다 크다면 무시하고 지나감.
            if (cost>arr[x][y]) continue;;

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<n) {
                    int newCost = cost + map[nx][ny];

                    //더 작은 비용이 된다면 갱신
                    if (newCost<arr[nx][ny]) {
                        arr[nx][ny] = newCost;
                        queue.add(new int[]{nx, ny, newCost});
                    }
                }
            }
        }

        return arr[n-1][n-1];
    }
}
