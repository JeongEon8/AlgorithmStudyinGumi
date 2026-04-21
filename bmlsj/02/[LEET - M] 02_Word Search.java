class Solution {
    
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n, m;
    static char[] words;
    public static boolean exist(char[][] board, String word) {

        
        words = word.toCharArray();
        
        m = board.length;
        n = board[0].length;
        char start = word.charAt(0);
        String tmp = null;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                if (!visited[i][j] && board[i][j] == start) {
                    tmp = dfs(i, j, String.valueOf(start), 0, board);
                    if (tmp != null && tmp.equals(word))
                        return true;
                }
            }
        }

        return false;

    }

    private static String dfs(int x, int y, String str, int idx, char[][] board) {

        if (idx == words.length - 1) {
            return str;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;

            if (!visited[nx][ny] && board[nx][ny] == words[idx + 1]) {

                String result = dfs(nx, ny, str + words[idx + 1], idx + 1, board);
                if (result != null && result.equals(new String(words))) {
                    return result;
                }
            }
        }

        visited[x][y] = false;
        return null;

    }
}