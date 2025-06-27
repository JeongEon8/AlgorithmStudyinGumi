package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
	
public class Baekjoon9019 {
	
	static String[] type = {"D","S","L","R"};
	static int B;
	static Queue<Node> que;
	static boolean[] visited;
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t<T; t++) {
			
			String[] input = in.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);
			visited = new boolean[10000];
			que = new ArrayDeque<>();
			que.add(new Node(A,""));
			
			String result = bfs();
			System.out.println(result);
			
		}
		
		
		
	}
	
	static class Node{
		int num;
		String comment;
		
		Node(int num, String comment){
			this.num = num;
			this.comment = comment;
		}
	}
	
	public static String bfs() {
		while(!que.isEmpty()) {
			Node node = que.poll();
			int num = node.num;
			String comment = node.comment;
			
			if(num==B) {
				return comment;
			}
			for(int i =0; i<4; i++) {
				String c = type[i];
				int total = 0;
				
				if(i==0) {
					total = d(num);
				}else if(i==1) {
					total = s(num);
				}else if(i==2) {
					total = l(num);
				}else {
					total = s(num);
				}
				if(!visited[total]) {
					visited[total]=true;
					que.add(new Node(total,comment+c));
				}
			}
			
		}
		
		
	    return "";
	}
	
	public static int d(int n) {
		int result = n*2;
		
		// 9999 보다 큰경우 10000을 나눈 나머지로 변환
	
		result %= 10000;
		
		
		return result;
	}
	
	public static int s(int n) {
		int result = n-1;
		
		// 0보다 작은경우 9999로 변환
		if(result<0) {
			result = 9999;
		}
		
		return result;
	}
	
	public static int l(int n) {
		int d1 = n/1000;
		int d2 = (n%1000)*10;
		int result = d1+d2;
		return result;
	}
	
	public static int r(int n) {
		int d1 = (n%10)*1000;
		int d2 = n/10;
		int result = d1+d2;
		return result;
	}

}
