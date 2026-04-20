import java.util.*;

class Solution {
    
    static int N;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        
        boolean[][] visitedTable = new boolean[N][N];
        boolean[][] visitedBoard = new boolean[N][N];
        
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> pieces = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedBoard[i][j] && game_board[i][j] == 0) {
                    blanks.add(getShape(game_board, visitedBoard, i, j, 0));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedTable[i][j] && table[i][j] == 1) {
                    pieces.add(getShape(table, visitedTable, i, j, 1));
                }
            }
        }
        
        int answer = 0;
        boolean[] used = new boolean[pieces.size()];

        for (List<int[]> blank : blanks) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) continue;
                if (blank.size() != pieces.get(i).size()) continue;

                List<int[]> piece = pieces.get(i);
                boolean matched = false;

                for (int r = 0; r < 4; r++) {
                    piece = rotate(piece);

                    if (isSame(blank, piece)) {
                        used[i] = true;
                        answer += blank.size();
                        matched = true;
                        break;
                    }
                }

                if (matched) break;
            }
        }

        return answer;
    }
    
    private List<int[]> getShape(int[][] board, boolean[][] visited, int sx, int sy, int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> shape = new ArrayList<>();

        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        shape.add(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != target) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                shape.add(new int[]{nx, ny});
            }
        }

        return normalize(shape);
    }
   
    private List<int[]> normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> normalized = new ArrayList<>();
        for (int[] p : shape) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }

        normalized.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return normalized;
    }
    
    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();

        for (int[] p : shape) {
            rotated.add(new int[]{p[1], -p[0]});
        }

        return normalize(rotated);
    }

    private boolean isSame(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) {
                return false;
            }
        }

        return true;
    }
}