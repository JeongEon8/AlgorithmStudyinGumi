import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String str = bf.readLine();
        
        int[] nums = new int[N];
        int top = -1;
        double[] stack = new double[str.length()];

        for(int i = 0;i < N; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        for(int i = 0; i < str.length(); i++) {
            switch(str.charAt(i)) {
                case '+':
                    stack[top-1] += stack[top];
                    top--;
                    break;
                case '-':
                    stack[top-1] -= stack[top];
                    top--;
                    break;
                case '*':
                    stack[top-1] *= stack[top];
                    top--;
                    break;
                case '/':
                    stack[top-1] /= stack[top];
                    top--;
                    break;
                default:
                    stack[++top] = (double)nums[str.charAt(i)-'A'];
            }
        }
        System.out.printf("%.2f\n", stack[top]);
    }
}
