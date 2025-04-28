package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon28279 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Deque<Integer> deque = new LinkedList<>();
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			if(input[0].equals("1")) {
				int num = Integer.parseInt(input[1]);
				deque.addFirst(num);
			}else if(input[0].equals("2")) {
				int num = Integer.parseInt(input[1]);
				deque.addLast(num);
			}else if(input[0].equals("3")) {
				if(deque.size()>0) {
					System.out.println(deque.removeFirst());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("4")) {
				if(deque.size()>0) {
					System.out.println(deque.removeLast());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("5")) {
				
					System.out.println(deque.size());
				
			}else if(input[0].equals("6")) {
				if(deque.size()>0) {
					System.out.println(0);
				}else {
					System.out.println(1);
				}
			}else if(input[0].equals("7")) {
				if(deque.size()>0) {
					System.out.println(deque.peekFirst());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("8")) {
				if(deque.size()>0) {
					System.out.println(deque.peekLast());
				}else {
					System.out.println(-1);
				}
			}
			
		}

	}

}
