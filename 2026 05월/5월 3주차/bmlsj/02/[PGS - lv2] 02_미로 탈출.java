import java.util.*;

class Solution {
    
    static class Node {
        int x, y, dist;
        boolean lever;
        
        Node(int x, int y, int dist, boolean lever) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.lever = lever;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        char[][] map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        // 레버(L)를 당겨 열기
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'S') {
                    return start(i, j, map);
                }
            }
        }

        return -1;
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int start(int x, int y, char[][] map) {
        
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        queue.offer(new Node(x, y, 0, false));
        visited[x][y][0] = true;
        
        while(!queue.isEmpty()) {
            
            Node curr = queue.poll();
            
            
            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                boolean nextLever = curr.lever;
                
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                
                if (map[nx][ny] == 'L') {
                    nextLever = true;
                }
                
                if (nextLever && map[nx][ny] == 'E') {
                    return curr.dist + 1;
                }
                
                int state = nextLever ? 1 : 0;
                if (!visited[nx][ny][state] && map[nx][ny] != 'X') {
                    visited[nx][ny][state] = true;
                    queue.offer(new Node(nx, ny, curr.dist + 1, nextLever));
                }
            }
            
        }
        
        return -1;
    }
}