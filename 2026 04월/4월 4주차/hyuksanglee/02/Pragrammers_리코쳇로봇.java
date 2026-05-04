package programmers;

import java.util.*;

public class Pragrammers_리코쳇로봇 {

	class Info {
        int x, y, count;
        Info(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(String[] board) {
        int R = board.length;
        int C = board[0].length();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        int[][] arr = new int[R][C];
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        
        for (int i = 0; i < R; i++) {
            String data = board[i];
            for (int j = 0; j < C; j++) {
                char c = data.charAt(j);
                if (c == 'D') arr[i][j] = 1;
                else if (c == 'R') {
                    startX = i; startY = j;
                } else if (c == 'G') {
                    endX = i; endY = j;
                }
            }
        }

        Queue<Info> que = new LinkedList<>();
        boolean[][] check = new boolean[R][C];
        
        que.add(new Info(startX, startY, 0));
        check[startX][startY] = true;
        
        while (!que.isEmpty()) {
            Info cur = que.poll();
            
            if (cur.x == endX && cur.y == endY) {
                return cur.count;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x;
                int ny = cur.y;
                
                while (nx + dx[d] >= 0 && nx + dx[d] < R && 
                       ny + dy[d] >= 0 && ny + dy[d] < C && 
                       arr[nx + dx[d]][ny + dy[d]] != 1) {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                
                if (!check[nx][ny]) {
                    check[nx][ny] = true;
                    que.add(new Info(nx, ny, cur.count + 1));
                }
            }
        }
        return -1; 
    }

}
