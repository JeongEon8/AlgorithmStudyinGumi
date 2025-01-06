import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

public static void main(String args[]) throws Exception {

    System.setIn(new FileInputStream("input_1861.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken()); // 테케 개수

    for (int test_case = 1; test_case <= T; test_case++) {
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로세로 길이

        int[][] rooms = new int[N][N];

        for (int i = 0; i < N; i++) { 
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int[] max = {Integer.MAX_VALUE,0}; // 0번째가 방 숫자 1번째가 moves

        for(int j = 0; j < N; j++){
            for (int k = 0; k< N; k++){
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(j,k));
                int moves = 1;
                while(queue.size() != 0){
                    Point curNode = queue.poll();
    
                    for (int i = 0; i < 4; i++) {
                        int nextX = curNode.x + dx[i];
                        int nextY = curNode.y + dy[i];
    
                        if(nextX > -1 && nextX < N && nextY > -1 && nextY < N && rooms[nextX][nextY] == rooms[curNode.x][curNode.y]+1) {
                            queue.add(new Point(nextX, nextY));
                            moves += 1;
                        }
                    }
                }
                if(max[1] < moves) {
                    max[0] = rooms[j][k];
                    max[1] = moves;
                }else if(max[1] == moves && max[0] > rooms[j][k]){
                    max[0] = rooms[j][k];
                }
            }
        }
        System.out.println("#" + test_case+" "+max[0]+" "+max[1]);

    }
}
}
