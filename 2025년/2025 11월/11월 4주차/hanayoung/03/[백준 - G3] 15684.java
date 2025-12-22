import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        boolean[][] maps = new boolean[H + 1][N + 1];

        List<Point> candidates = new ArrayList<>();

        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < N; j++) {
                candidates.add(new Point(i, j));
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[a][b] = true;
            candidates.remove(new Point(a, b));
        }

        int[] current = {-1, -1, -1};
        boolean[][] visited = new boolean[H+1][N+1];
        for(int k = 0; k <= 3; k++) {
            for(int t = 0; t < current.length; t++) current[t] = -1;
            for(int t = 1; t < H+1; t++) {
                for(int l = 1; l < N+1; l++) {
                    visited[t][l] = false;
                }
            }
            recur(0, 0, current, visited, N, H, k, maps, candidates);
            if(answer != -1) break;
        }
        

        System.out.println(answer);
    }

    public static void recur(int depth, int r, int[] current, boolean[][] visited, int N, int H, int maxK, boolean[][] maps, List<Point> candidates) {
        if (answer == 0) {
            return;
        }
        if(answer != -1 && depth >= answer) return;

        if (depth == maxK) {
            if(check(current, candidates, maps, H, N) == false) return;
            if(answer != -1) {
                answer = Math.min(answer, depth);
            } else {
                answer = depth;
            }
            return;
        }

        for (int i = r; i < candidates.size(); i++) {
            Point candidate = candidates.get(i);
            if((candidate.y - 1 >= 0 && visited[candidate.x][candidate.y - 1]) || (candidate.y + 1 < N+1 && visited[candidate.x][candidate.y + 1])) continue;
            current[depth] = i;
            visited[candidate.x][candidate.y] = true;
            maps[candidate.x][candidate.y] = true;
            recur(depth + 1, i + 1, current, visited, N, H, maxK, maps, candidates);
            current[depth] = -1;
            visited[candidate.x][candidate.y] = false;
            maps[candidate.x][candidate.y] = false;
        }

    }

    public static boolean check(int[] current, List<Point> candidates, boolean[][] maps, int H, int N) {
        for (int i = 1; i < N + 1; i++) {
            int curH = 1;
            int curN = i;
            while (curH <= H) {
                if (curN < N && maps[curH][curN] == true) {
                    // 이동하는 걸 마주치면 무조건 이동해야 함
                    curN += 1;
                    
                } else if (curN > 1 && maps[curH][curN - 1] == true) {
                    curN -= 1;
                }
                curH++;
            }
            if (curN != i) {
                return false;
            }
        }

        return true;
    }
}

