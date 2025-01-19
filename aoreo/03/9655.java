import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int turn = -1; // 턴이 짝수면 상근이가 이긴 거고, 홀수면 창영이가 이긴 것
        String answer = "SK";
        while(N > 0) {
            if(N < 3) {
                N -= 1;
            }else {
                N -= 3;
            }
            turn += 1;
        }

        if(turn % 2 != 0) answer = "CY";

        System.out.println(answer);
    }
}
