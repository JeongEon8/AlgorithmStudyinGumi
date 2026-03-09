package 정렬;

import java.io.*;
import java.util.*;

public class Baekjoon1431 {
	static class Info implements Comparable<Info> {
		
		String serial;
		int len;
		long totalN;
		long totalC;

		@Override
		public int compareTo(Info o) {
			if(o.len != this.len) {
				return this.len - o.len;
			}
			if(o.totalN != this.totalN) {
				return (int)(this.totalN - o.totalN);
			}
					
			return (int)(this.totalC - o.totalC);
	
		
		}
		
	}

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
		int N = Integer.parseInt(in.readLine());
		
		List<Info> list = new ArrayList<Info>();
		for(int n = 0; n<N; n++) {
			String input = in.readLine();
			Info info = new Info();
			info.serial = input;
			info.len = input.length();
			long totalN = 0;
			long totalC = 0;
			for(int i = 0; i<info.len; i++) {
				char c = input.charAt(i);
				if(c<60) {
					totalN += c-'0';
					totalC = totalC*36 + c-'0';
				}else {
					totalC = totalC*36 + (c-'A')+10;
				}
				
			}
			info.totalN =totalN;
			info.totalC= totalC;
			
			list.add(info);
		}
		
		Collections.sort(list);

		for(int i = 0; i<N; i++) {
			System.out.println(list.get(i).serial);
			
		}
	}

}
