import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static int n, m;
    static char[][] arr;
    static Map<String, Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        String[] words = new String[k];
        for (int i = 0; i < k; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            dp = new HashMap<>();
            bw.write(countWords(word) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int countWords(String word) {
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    totalCount += dfs(i, j, word, 1); // 첫 문자 일치하면 dfs 시작
                }
            }
        }
        return totalCount;
    }

    public static int dfs(int x, int y, String word, int idx) {
        // 미리 계산해둔 결과 있으면 반환 
        String key = x + "," + y + "," + idx;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // 마지막 문자까지 도달하면 +1
        if (idx == word.length()) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nx = (x + dx[i] + n) % n;
            int ny = (y + dy[i] + m) % m;

            if (arr[nx][ny] == word.charAt(idx)) {
                count += dfs(nx, ny, word, idx + 1);
            }
        }

        // dp에 결과 저장...
        dp.put(key, count);
        return count;
    }
}
