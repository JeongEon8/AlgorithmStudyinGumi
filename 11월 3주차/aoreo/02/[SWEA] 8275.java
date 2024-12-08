import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    static int[] sel;
    static int X;
    static int N;
    static Memo[] memo;
    static int[] answerArr;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); // 우리 수
            X = Integer.parseInt(st.nextToken()); // 우리 당 최대 햄스터 마리 수
            int M = Integer.parseInt(st.nextToken()); // 메모 개수

            memo = new Memo[M];
            answerArr = new int[N]; // 최대 햄스터 배열
            max = -1; // 최대 햄스터 마리 수

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int l = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                int s = Integer.parseInt(st.nextToken());
                memo[i] = new Memo(l, r, s);
            }

            sel = new int[N]; // 햄스터 수 배열
            comb(0);
            
            if(max == -1) { // 만족하는 배열이 없는 경우의 출력
              System.out.println("#"+tc+" -1");
            } else{ 
              System.out.print("#"+tc);
              for (int i = 0; i < N; i++) {
                  System.out.print(" "+answerArr[i]);
              }
              System.out.println("");
            }

        }
    }

    static void comb(int r){
        if(r == N){
            check();
            return;
        }
        for (int i = 0; i <= X; i++) {
            sel[r] = i;
            comb(r+1);
        }
    }

    static void check(){ // 만든 배열이 햄스터 메모와 들어맞는지 확인
        int cnt = 0;
        for (int i = 0; i < memo.length; i++) { // 메모 수만큼 반복
            int sum = 0;
            for (int j = memo[i].l; j <= memo[i].r; j++) { // l번째 우리부터 r번째 우리까지 확인
                sum += sel[j]; 
                if(sum > memo[i].s) return; // 세고 있는데 이미 total보다 커? 글렀네
            }
            if(sum != memo[i].s) return; // l번째 우리부터 r번째 우리까지의 햄스터 합계가 s와 달라? 글렀네
        }

        for (int i = 0; i < N; i++) {
          cnt += sel[i]; // 햄스터 합계
        }

        if(cnt > max) {
            max = cnt;
            answerArr = sel.clone();
        }
    }

    static class Memo{ // l번째 우리부터, r번째 우리까지, 합계는 s마리
        int l;
        int r;
        int s;

        public Memo(int l, int r, int s){
            this.l = l;
            this.r = r;
            this.s = s;
        }
    }
}
