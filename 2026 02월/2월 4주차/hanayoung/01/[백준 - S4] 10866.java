import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X;
        Queue<Integer> tmp = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            switch(st.nextToken()) {
                case "push_front":
                    tmp.clear();
                    X = Integer.parseInt(st.nextToken());
                    tmp.add(X);
                    tmp.addAll(q);
                    q.clear();
                    q.addAll(tmp);
                    break;
                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    q.add(X);
                    break;
                case "pop_front":
                    if(q.size() > 0) sb.append(q.poll()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "pop_back":
                    if(q.size() > 0) {
                        tmp.clear();
                        while(q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        sb.append(q.poll()).append("\n");
                        q.addAll(tmp);
                    } else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.size() == 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(q.size() > 0) sb.append(q.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if(q.size() > 0) {
                        tmp.clear();
                        while(q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        int last = q.poll();
                        sb.append(last).append("\n");
                        q.addAll(tmp);
                        q.add(last);
                    } else sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
