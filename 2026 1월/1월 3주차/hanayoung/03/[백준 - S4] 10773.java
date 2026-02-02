import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) stack.pop();
            else stack.push(num);
        }

        while(stack.size() > 0) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
