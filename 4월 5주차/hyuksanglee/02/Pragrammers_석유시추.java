package programmers;
import java.util.*;
public class Pragrammers_석유시추 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;
    static int count;

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int answer = 0;
        int[] result = new int[m]; 
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !check[i][j]) {
                    check[i][j] = true;
                    count = 0;
                    Set<Integer> set = find(j, i, land);
                    
                    for (int num : set) {
                        result[num] += count;
                        if (answer < result[num]) {
                            answer = result[num];
                        }
                    }
                }
            }
        }
        return answer;
    }

    class Info {
        int x, y;
        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Set<Integer> find(int x, int y, int[][] land) {
        Set<Integer> set = new HashSet<>();
        Queue<Info> que = new ArrayDeque<>();
        
        que.add(new Info(x, y));
        count = 1;
        set.add(x);

        while (!que.isEmpty()) {
            Info data = que.poll();
            for (int d = 0; d < 4; d++) {
                int nx = data.x + dx[d];
                int ny = data.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= land[0].length || ny >= land.length) {
                    continue;
                }

                if (land[ny][nx] == 1 && !check[ny][nx]) {
                    check[ny][nx] = true;
                    set.add(nx);
                    count++; 
                    que.add(new Info(nx, ny));
                }
            }
        }
        return set;
    }
}


