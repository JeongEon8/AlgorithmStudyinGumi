package dp;

import java.io.*;
import java.util.*;

public class Baekjoon2240 {

	public static void main(String[] args)throws Exception {
		
		
			int n =22;
			int w = 6;
			int num = 8;
	        int answer = 0;
	        
	        Stack<Integer>[] stacks = new Stack[w];
	        int[] saveNum = new int[n+1];
	        for(int i = 0; i<w; i++){
	            stacks[i] = new Stack<Integer>();
	        }
	        
	        
	        int type = 1;
	        int index = 0;
	        for(int i=0; i<n; i++){
	            if(index>=w){
	                type = -1;
	                index = w -1;
	            }else if(index<0){
	                type = 1;
	                index =0;
	            }
	           
	            stacks[index].push(i+1);
	            
	            saveNum[i+1] = index;
	            index += type;
	            
	        }
	        
	      
	        index = saveNum[num];
	        int s = 0;
	        while(s != num) {
	        	answer++;
	        	s = stacks[index].pop();
	        }
	       
	        
	        System.out.print(answer);
	    }

	

}
