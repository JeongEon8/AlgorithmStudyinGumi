import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            switch(command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.add(x);
                    break;
                case "pop":
                    if(stack.size() > 0) {
                        sb.append(stack.get(stack.size()-1)).append("\n");
                        stack.remove(stack.size()-1);
                    }
                    else sb.append("-1").append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.size() > 0) sb.append("0").append("\n");
                    else sb.append("1").append("\n");
                    break;
                case "top":
                    if(stack.size() > 0) sb.append(stack.get(stack.size()-1)).append("\n");
                    else sb.append("-1").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}4
