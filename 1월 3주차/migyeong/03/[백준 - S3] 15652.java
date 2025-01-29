import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon15652 {
    
    static int N, M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        num = new int[M];

        combi(1, 0);
        
        System.out.println(sb);
    }

    private static void combi(int start, int cnt) {

        if (cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            num[cnt] = i;
            combi(i, cnt + 1); 
        }
    }
}