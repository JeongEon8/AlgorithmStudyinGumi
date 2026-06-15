import java.util.*;
class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] map;
    static int cnt;
    public int[] solution(String[] maps) {
        
        List<Integer> ans = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        map = new char[n][m];
        
        for(int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    cnt = map[i][j] - '0';
                    visited[i][j] = true;
                    func(i, j, n, m);
                    ans.add(cnt);
                }
            }
        }
        
        if (ans.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    static void func(int x, int y, int n, int m) {
        
        visited[x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        
        while(!queue.isEmpty()) {
            
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                    cnt += map[nx][ny] - '0';
                }
            }
        }
        
    }
}