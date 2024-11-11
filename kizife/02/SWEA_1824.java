import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
 
    static int n, m;
    static char[][] arr;
    static boolean[][][][] visit;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
 
    static class State {
        int x, y, memory, dir;
 
        public State(int x, int y, int memory, int dir) {
            this.x = x;
            this.y = y;
            this.memory = memory;
            this.dir = dir;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new char[n][m];
            visit = new boolean[n][m][16][4]; //[x][y][메모리][방향]
 
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }
 
            String answer = dfs(0, 0, 0, 3) ? "YES" : "NO";
 
            System.out.println("#" + tc + " " + answer);
        }
    }
 
    private static boolean dfs(int startX, int startY, int startMemory, int startDir) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(startX, startY, startMemory, startDir));
 
        while (!stack.isEmpty()) {
            State current = stack.pop();
            int x = current.x;
            int y = current.y;
            int memory = current.memory;
            int dir = current.dir;
 
            // 범위 벗어나면 반대편으로
            if (x < 0) x = n - 1;
            if (x >= n) x = 0;
            if (y < 0) y = m - 1;
            if (y >= m) y = 0;
 
            // 이미 방문한 상태라면... 지금 스택 항목 넘어가고 다음 걸로
            if (visit[x][y][memory][dir]) continue;
            visit[x][y][memory][dir] = true;
 
            char cha = arr[x][y]; //해당 위치에 있는 문자
 
            if (cha == '@') return true; //@에 도달하면 true 반환
            else if (cha >= '0' && cha <= '9') memory = cha - '0'; //- '0'으로 int변환, 메모리에 넣음
            else if (cha == '<') dir = 2; //방향전환
            else if (cha == '>') dir = 3;
            else if (cha == '^') dir = 0;
            else if (cha == 'v') dir = 1;
            else if (cha == '_') dir = (memory == 0) ? 3 : 2; // 수평 이동 방향 결정
            else if (cha == '|') dir = (memory == 0) ? 1 : 0; // 수직 이동 방향 결정
            else if (cha == '?') {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    stack.push(new State(nx, ny, memory, i));
                }
                continue;
            } else if (cha == '+') memory = (memory + 1) % 16;
            else if (cha == '-') memory = (memory == 0) ? 15 : memory - 1;
 
            stack.push(new State(x + dx[dir], y + dy[dir], memory, dir));
        }
 
        return false; //다 봤는데 @ 도달 못 하면 false
    }
}
 
//첨엔 stack 안 쓰고 풀었는데 런타임에러(스택오버플로우) 나서... 고침
