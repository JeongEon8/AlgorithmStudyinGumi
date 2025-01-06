import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int[] ops;
    static int[] nums;
    static Character[] sel;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // 수의 개수
        
        st = new StringTokenizer(bf.readLine());
        nums = new int[N];
        ops = new int[4];
        
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        sel = new Character[N-1];

        perm(0);

        System.out.println(max+"\n"+min);
    }

    static void perm(int r){
        if(r == N-1) {
            int sum = nums[0];
            for (int i = 0; i < sel.length; i++) {
                switch(sel[i]) {
                    case '+' :
                    sum += nums[i+1];
                    break;
                    case '-':
                    sum -= nums[i+1];
                    break;
                    case '*':
                    sum *= nums[i+1];
                    break;
                    case '/':
                    sum /= nums[i+1];
                    break;
                }
            }
            if(sum < min) min = sum;
            if(sum > max) max = sum;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(ops[i] > 0) {
                switch(i) {
                    case 0 : sel[r] = '+';
                    break;
                    case 1 : sel[r] = '-';
                    break;
                    case 2 : sel[r] = '*';
                    break;
                    case 3 : sel[r] = '/';
                    break;
                }
                ops[i] -= 1;
                perm(r+1);
                ops[i] += 1;
            }
        }
    }
}
