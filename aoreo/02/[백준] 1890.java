import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][N];
        Long[][] routes = new Long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                routes[i][j] = 0L;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        routes[0][0] = 1L;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(routes[i][j] != 0){
                    if(maps[i][j] == 0) continue;;
                    if(i+maps[i][j] < N) routes[i+maps[i][j]][j] += routes[i][j];
                    if(j+maps[i][j] < N) routes[i][j+maps[i][j]] += routes[i][j];
                }
            }
        }
        System.out.println(routes[N-1][N-1]);
    }
}

