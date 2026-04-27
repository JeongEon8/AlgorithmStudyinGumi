package 시뮬레이션;

import java.io.*;
import java.util.*;

public class Baekjoon15686 {
	
	static class Info{
		int i;
		int j;
		Info(int i, int j){
			this.i = i;
			this.j =j;
		}
	}
	
	static int N,M,sizeC;
	
	static int[] pick;
	static 	int[][] di ;
	
	static List<Info>home;
	static List<Info> chicken ;
	static int result;

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		sizeC =0;
		result = Integer.MAX_VALUE;
		
		home = new ArrayList<Info>();
		chicken = new ArrayList<Info>();
		pick = new int[M];
		
		for(int i = 0; i<N; i++) {
			input = in.readLine().split(" ");
			for(int j = 0; j<N; j++) {
				int num = Integer.parseInt(input[j]);
				
				if(num ==1) {
					Info ih = new Info(i,j);
					home.add(ih);
				}
				else if(num ==2 ) {
					Info ic = new Info(i,j);
					chicken.add(ic);
					sizeC++;
				}
			}
		}
		
	di = new int[chicken.size()][home.size()]; 
		
		 for(int i = 0; i<chicken.size(); i++) {
	        	
			 int c = chicken.get(i).i;
			 int r = chicken.get(i).j;
			 for(int j = 0 ; j<home.size(); j++) {
				 
				 di[i][j] = Math.abs(c-home.get(j).i) + Math.abs(r-home.get(j).j);
				 
			 }
        }
		
		
		combination(0,0);
		System.out.print(result);
		
		
	}
	
	
	static void combination(int depth, int start) {
	   
	    if (depth == M) {
	    	int total =0;
	        for(int i = 0; i<home.size(); i++) {
	        	int min = Integer.MAX_VALUE;
	        	for(int j = 0; j<M; j++) {
	        		if(min > di[pick[j]][i]) {
	        			min = di[pick[j]][i];
	        		}
	        	}
	        	total+= min;
	        	
	        	
	        }
	        if(result > total) {
        		result = total;
        	}
	        return;
	    }
	    
	    for (int i = start; i < sizeC; i++) {
	        pick[depth] = i;
	        combination(depth + 1, i + 1);
	    }
	}

}
