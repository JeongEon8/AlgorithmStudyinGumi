package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Beakjoon2644 {
	static int[] arr;
	static ArrayList<Integer> aP = new ArrayList<>();
	static ArrayList<Integer> bP = new ArrayList<>();
	static int result = -1;
	
	public static void dfs(int n, int y , ArrayList<Integer> p ) {
		if(arr[n] == y) {
			result = p.size()+1;
			return;
		}
		
		if(arr[n]== n) {
			return;
		}
		p.add(arr[n]);
		dfs(arr[n], y, p);
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		arr = new int[n+1];
		// 자기자신으로 초기화
		for(int i =0; i<=n; i++) {
			arr[i]=i;
		}
		
		String[] input = in.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		int m = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < m; i++) {
			input = in.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			arr[y]= x;
		}
		dfs(a, b, aP);
		if(result == -1) {
			dfs(b,a,bP);
		}
		
		int check =0;
		if(result == -1) {
			for(int i = 0; i<aP.size(); i++) {
				for(int j = 0; j<bP.size(); j++) {
					if(aP.get(i) == bP.get(j)) {
						result = i+j+2;
						check =1;
						break;
					}
				}
				if(check ==1) {
					break;
				}
			}
		}
		
		if(a == b) {
			result=0;
		}
		
		System.out.print(result);
		
	}

	
}
