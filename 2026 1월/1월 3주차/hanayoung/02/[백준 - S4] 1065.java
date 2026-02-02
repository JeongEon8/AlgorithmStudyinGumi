import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int i = 1; i <= N; i++) {
            if(i < 100) {
                answer++;
            } else {
                int check = i/10;
                int diff = (i/10)%10 - i % 10;
                while(check/10 > 0) {
                    if((check/10) % 10 - check % 10 == diff) {
                        check /= 10;
                    }
                    else break;
                }
                if(check/10 == 0) answer++;
            }
        }

        System.out.println(answer);
    }
}
