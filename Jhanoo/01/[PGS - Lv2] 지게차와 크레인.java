import java.util.*;

class Solution {
    
    static int N, M;
    static int[][] visited;
    static int answer;
    
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    
    static final int YET_CAN_REACH = 0;     // 미출고(도달 가능)
    static final int YET_CANT_REACH = 1;    // 미출고(도달 불가능)
    static final int OUT_CAN_REACH = 2;     // 출고(도달 가능)
    static final int OUT_CANT_REACH = 3;    // 출고(도달 불가능)
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        answer = N * M;
        
        visited = new int[N][M];
        
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                visited[i][j] = YET_CANT_REACH;
            }
        }
        
        for (String request : requests) 
            pick(storage, request);
        
        return answer;
    }
    
    private void pick(String[] storage, String request) {
        char c = request.charAt(0);
        
        // 크레인 사용
        if (request.length() == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == YET_CAN_REACH && storage[i].charAt(j) == c) {
                        visited[i][j] = OUT_CAN_REACH;
                        answer--;
                    } else if (visited[i][j] == YET_CANT_REACH && storage[i].charAt(j) == c) {
                        visited[i][j] = OUT_CANT_REACH;
                        answer--;
                    } 
                }
            }
        } 
        // 접근 가능한 컨테이너 출고
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == YET_CAN_REACH && storage[i].charAt(j) == c) {
                        visited[i][j] = OUT_CAN_REACH;
                        answer--;
                    }
                }
            }
        }
        
        check(storage);
    }
    
    private void check(String[] storage) {
        boolean[][] v = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == OUT_CAN_REACH && !v[i][j]) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    v[i][j] = true;
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc])
                                continue;
                            
                            if (visited[nr][nc] == OUT_CANT_REACH)
                                visited[nr][nc] = OUT_CAN_REACH;

                            if (visited[nr][nc] == YET_CANT_REACH)             
                                visited[nr][nc] = YET_CAN_REACH;
                            
                            if (visited[nr][nc] == OUT_CAN_REACH)
                               q.offer(new int[] {nr, nc});
                            
                            v[nr][nc] = true;
                        }
                    }
                }  
            }
        }
    }
    
}
