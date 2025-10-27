package 트리;

import java.io.*;
import java.util.*;

public class Baekjoon15681 {
	
	static class Node{
		int n;
		List<Integer> ch;
		Node(int n,  int ch){
			this.n = n;
			 if (this.ch == null) {
		            this.ch = new ArrayList<>();
		        }

		        // 초기화된 ch 리스트에 자식 노드 번호 추가
		        this.ch.add(ch);
		}
	}
	
	static int[]arr;
	
	static Node[] list;
	
	static boolean[] check;

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int R = Integer.parseInt(input[1]);
		int Q = Integer.parseInt(input[2]);
		
		arr = new int [N+1];
		check = new boolean [N+1];
		
		list = new Node[N+1];
		// 그래프 연결
		for(int i = 0; i<N-1; i++) {
			input = in.readLine().split(" ");
			int U = Integer.parseInt(input[0]);
			int V = Integer.parseInt(input[1]);
			
			if(list[U]== null) {
				Node node = new Node(U,V);
				list[U] = node;
			}else {
				list[U].ch.add(V);
			}
			
			if(list[V]== null) {
				Node node = new Node(V,U);
				list[V] = node;
			}else {
				list[V].ch.add(U);
			}
			
		}
		
		
		dfs(list[R]);
		
		for(int i = 0; i<Q; i++) {
			int q = Integer.parseInt(in.readLine());
			System.out.println(arr[q]);
		}

	}
	
	static int dfs(Node node) {
		int count =1;
		check[node.n] = true;
		for(int i = 0; i<node.ch.size(); i++) {
			int num = node.ch.get(i);
			if(!check[num]) {
				count += dfs(list[num]);
			}
		}
		
		arr[node.n]= count;
		return count;
	}

}
