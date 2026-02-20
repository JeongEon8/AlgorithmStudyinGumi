import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            switch(st.nextToken()) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    q.add(X);
                    break;
                case "pop":
                    if(q.size() > 0) {
                        sb.append(q.poll());
                    }
                    else sb.append(-1);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.size() == 0) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case "front":
                    if(q.size() == 0) sb.append(-1);
                    else sb.append(q.peek());
                    sb.append("\n");
                    break;
                case "back":
                    if(q.size() == 0) sb.append(-1);
                    else {
                        Queue<Integer> tmp = new LinkedList<>();
                        while(q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        int last = q.poll();
                        sb.append(last);
                        q.addAll(tmp);
                        q.add(last);
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
