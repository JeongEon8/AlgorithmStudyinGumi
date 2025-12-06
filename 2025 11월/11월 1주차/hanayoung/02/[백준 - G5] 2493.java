import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Stack<Top> stack = new Stack<>();
        int[] height = new int[N];
        int[] ans = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            while(stack.size() > 0 && stack.peek().height <= height[i]) stack.pop();
            if(stack.size() > 0) ans[i] = stack.peek().id;
            else ans[i] = 0;
            stack.add(new Top(i+1, height[i]));
        }

        for(int i = 0 ; i< N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static class Top {
        int id;
        int height;

        public Top(int id, int height) {
            this.id = id;
            this.height = height;
        }
    }
}
