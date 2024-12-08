import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] box = new int[1000][1000];
    static int[][] cbox = new int[1000][1000];
    static int[][] tagbox = new int[1000][1000];
    static int[][] resultbox = new int[1000][1000];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int key = -1;
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                box[i][j] = tmp.charAt(j) - '0';
                if (tmp.charAt(j) - '0' == 1) {
                    tagbox[i][j] = 1;
                } else {
                    tagbox[i][j] = 0;
                }
            }
        }

        initcbox();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tagbox[i][j] == 0) {
                    tagboxbfs(i, j); // tagbox에 count가 들어간 해시키를 tag box에 넣기 count계산 + 해시맵
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tagbox[i][j] == 1) {
                    initresult(i, j);
                } else {
                    resultbox[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(Integer.toString(resultbox[i][j]));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void initresult(int y, int x) {
        HashMap<Integer, Boolean> done = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || tagbox[ny][nx] == 1) {
                continue;
            }
            if (done.get(tagbox[ny][nx]) == null) {
                resultbox[y][x] += map.get(tagbox[ny][nx]);
                done.put(tagbox[ny][nx], true);
            }
        }
        resultbox[y][x]++;
        resultbox[y][x] = resultbox[y][x] % 10;

    }


    private static void tagboxbfs(int y, int x) {
        Queue<Dot> q = new LinkedList<>();
        Queue<Dot> q4tag = new LinkedList<>();
        cbox[y][x] = 1;
        q.add(new Dot(y, x));
        q4tag.add(new Dot(y, x));
        while (!q.isEmpty()) {
            Dot d = q.poll();
            int nowy = d.y;
            int nowx = d.x;
            for (int i = 0; i < 4; i++) {
                int ny = nowy + dy[i];
                int nx = nowx + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || cbox[ny][nx] == 1) {
                    continue;
                }
                cbox[ny][nx] = 1;
                q.add(new Dot(ny, nx));
                q4tag.add(new Dot(ny, nx));
            }
        }
        map.put(key, q4tag.size());
        while (!q4tag.isEmpty()) {
            Dot d = q4tag.poll();
            tagbox[d.y][d.x] = key;
        }
        key--;
    }

    private static void initcbox() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cbox[i][j] = box[i][j];
            }
        }
    }

}

class Dot {
    int y;
    int x;

    Dot(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
