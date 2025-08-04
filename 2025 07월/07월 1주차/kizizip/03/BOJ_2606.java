import java.util.Scanner;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            map[x][y] = map[y][x] = 1;
        }
        
        dfs(1);
        System.out.println(count-1);
        

    }
    
    public static void dfs(int start) {
        visited[start] = true;
        count++;
        for (int i = 0; i <=n ; i++) {
            if (map[start][i] == 1 && !visited[i]) dfs(i);
        }
    }
}
