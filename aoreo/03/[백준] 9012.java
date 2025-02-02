import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') stack.add(1);
                else stack.add(-1);
            }
            int result = 0;
            while(stack.isEmpty() == false) {
                result += stack.pop();
                if(result > 0) {
                    System.out.println("NO");
                    break;
                }
            }
            if(stack.isEmpty() && result == 0) System.out.println("YES");
            else if(stack.isEmpty() && result < 0) System.out.println("NO");
        }
    }
}
