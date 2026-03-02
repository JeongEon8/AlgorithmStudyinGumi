package 수학;

import java.io.*;
import java.util.*;

public class Baekjoon9375 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0 ; t<T; t++) {
			
			int N = Integer.parseInt(in.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int n = 0; n<N; n++) {
				String [] input = in.readLine().split(" ");
				if(map.containsKey(input[1])) {
					map.put(input[1], map.getOrDefault(input[1], 0) + 1);
				}else {
					map.put(input[1],1);
				}
			}
			int total = 1;
			for(int count : map.values()) {
				total *= count +1;
			}
			System.out.println(total);
		}

	}

}
