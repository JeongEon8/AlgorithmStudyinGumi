import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int N = board.length;
        int M = board[0].length();
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        // queue에 x, y, 이동횟수 담기
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    q.add(new int[]{i,j,1});
                    break;
                }
            }
        }
        while(q.size() > 0) {
            int[] cur = q.poll();
            if(board[cur[0]].charAt(cur[1]) == 'G') {
                answer = cur[2] -1;
                break;
            }
            visited[cur[0]][cur[1]] = true;
            for(int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];
                while(nx+dx[i] >= 0 && nx+dx[i] < N && ny+dy[i] >= 0 && ny+dy[i] < M && board[nx+dx[i]].charAt(ny+dy[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                if(visited[nx][ny] == false && board[nx].charAt(ny) != 'D') {
                    q.add(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        
        return answer;
    }
}
