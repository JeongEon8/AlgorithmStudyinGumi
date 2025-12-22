package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon4195 {
	
	static int[] size;
	static Map<String, Integer> network;
	static int[] header;
	static int max;
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t<T; t++) {
			
			int F = Integer.parseInt(in.readLine());
			
			size = new int[2 * F + 1];
			header = new int[2 * F + 1];
			network = new HashMap<>();
			
			// 크기랑 헤더 초기화
			for (int i = 0; i < 2 * F + 1; i++) {
			    size[i] = 1;
			    header[i] = i;
			}
			
			int index =0;
			
			max = 0 ;
			
			for(int f = 0; f<F; f++) {
				
				// 친구 입력 받기
				String[] input = in.readLine().split(" ");
				String a = input[0];
				String b = input[1];
				
				if(!network.containsKey(a)) {
					network.put(a, index++);
				}
				if(!network.containsKey(b)) {
					network.put(b, index++);
				}
				
				union(a, b);
				
				
				
			}
		}
		

	}
	
	static void union(String a, String b) {
		int numA = network.get(a);
		int numB = network.get(b);
		
		int headerA = friendHeader(numA);
		int headerB = friendHeader(numB);
		
		if(headerA != headerB) {
			size[headerA] += size[headerB];
			header[headerB] = headerA;
		}
		
		
		System.out.println(size[headerA]);
	}
	
	//
	static int friendHeader(int num){
		
		if(header[num]!=num) {
			header[num]=friendHeader(header[num]);
		}
		
		return header[num];
	}

}
