import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Integer> stack = new Stack<>();
            String msg = br.readLine();
            boolean vps = true;

            for (int j = 0; j < msg.length(); j++) {
                // (이면 stack에 1을 넣는다
                if (msg.charAt(j)=='(') {
                    stack.push(1);
                } else {
                    if (stack.isEmpty()) {
                        // 닫는 괄호가 더 많아졌다면
                        vps = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                vps = false;
            }
            System.out.println(vps ? "YES" : "NO");

        }
    }
}
