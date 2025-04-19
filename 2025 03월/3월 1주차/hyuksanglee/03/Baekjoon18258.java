package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon18258 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                queue.offer(Integer.parseInt(input.split(" ")[1]));
            } else if (input.equals("pop")) {
                
                if(queue.isEmpty()) {
                	sb.append("-1\n");
                }else {
                	sb.append(queue.pop()).append("\n");
                }
            } else if (input.equals("size")) {
            	sb.append(queue.size()).append("\n");
            } else if (input.equals("empty")) {
            	if(queue.isEmpty()) {
            		sb.append(1).append("\n");
                }else {
                	sb.append(0).append("\n");
                }
            } else if (input.equals("front")) {
            	if(queue.isEmpty()) {
            		sb.append("-1\n");
                }else {
                	sb.append(queue.peekFirst()).append("\n");
                }
            } else if (input.equals("back")) {
            	if(queue.isEmpty()) {
            		sb.append("-1\n");
                }else {
                	sb.append(queue.peekLast()).append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

}
