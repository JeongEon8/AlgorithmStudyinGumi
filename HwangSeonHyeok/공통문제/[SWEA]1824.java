import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    static char[][] graph;
    static boolean[][][][] visited;
    // dir 0:우, 1:하, 2:좌, 3:상
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int r, c;

    static class State {
        int y, x, dir, memory;

        public State(int y, int x, int dir, int memory) {
            super();
            this.y = y;
            this.x = x;
            this.memory = memory;
            this.dir = dir;

        }

    }

    static int tc;

    static boolean bfs() {
        boolean flag = false;
        Queue<State> q = new ArrayDeque<>();

        q.add(new State(0, -1, 0, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            int nextX = cur.x + dx[cur.dir];
            int nextY = cur.y + dy[cur.dir];
            int nextDir = cur.dir;
            int nextMemory = cur.memory;
            if (nextX < 0) {
                nextX = c - 1;
            } else if (nextX == c) {
                nextX = 0;
            } else if (nextY < 0) {
                nextY = r - 1;
            } else if (nextY == r) {
                nextY = 0;
            }
            if (graph[nextY][nextX] == '@') {
                flag = true;
                break;
            }
            if (visited[nextY][nextX][nextDir][nextMemory])
                continue;
            visited[nextY][nextX][nextDir][nextMemory] = true;
            // dir 0:우, 1:하, 2:좌, 3:상
            char nextChar = graph[nextY][nextX];
            if (nextChar == '<') {
                nextDir = 2;
            } else if (nextChar == '>') {
                nextDir = 0;
            } else if (nextChar == '^') {
                nextDir = 3;
            } else if (nextChar == 'v') {
                nextDir = 1;
            } else if (nextChar == '_') {
                nextDir = nextMemory == 0 ? 0 : 2;
            } else if (nextChar == '|') {
                nextDir = nextMemory == 0 ? 1 : 3;
            } else if (nextChar >= '0' && nextChar <= '9') {
                nextMemory = graph[nextY][nextX] - '0';
            } else if (nextChar == '+') {
                nextMemory++;
                if (nextMemory == 16)
                    nextMemory = 0;
            } else if (nextChar == '-') {
                nextMemory--;
                if (nextMemory == -1)
                    nextMemory = 15;
            }

            if (nextChar == '?') {
                for (int i = 0; i < 4; i++) {
                    visited[nextY][nextX][i][nextMemory] = true;
                    q.add(new State(nextY, nextX, i, nextMemory));
                }
            } else {
                q.add(new State(nextY, nextX, nextDir, nextMemory));
            }

        }

        return flag;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (tc = 1; tc <= T; tc++) {
            String[] split = in.readLine().split(" ");
            r = Integer.parseInt(split[0]);
            c = Integer.parseInt(split[1]);
            graph = new char[r][c];
            visited = new boolean[r][c][4][16];
            for (int i = 0; i < r; i++) {
                String line = in.readLine();
                for (int j = 0; j < c; j++) {
                    graph[i][j] = line.charAt(j);
                }
            }
            if (bfs()) {
                System.out.println("#" + tc + " " + "YES");
            } else {
                System.out.println("#" + tc + " " + "NO");
            }

        }

    }

}