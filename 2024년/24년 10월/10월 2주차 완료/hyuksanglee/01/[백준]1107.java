package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Baekjoon1107 {

    public static int[] num;
    public static int N;

    

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int min= Integer.MAX_VALUE;

        int M = Integer.parseInt(in.readLine());
        num = new int[M];
        
        if(M!=0) {
        	String[] input = in.readLine().split(" ");
        	 for (int m = 0; m < M; m++) {
                 num[m] = Integer.parseInt(input[m]);
             }
             
        }
       
        for(int i = 0; i<=600000;i++) {
        	boolean check = false;
        	for(int n:num) {
        		if((i+"").contains(n+"")) {
        			check= true;
        			break;
        		}
        	}
        	if(check) {
        		continue;
        	}
        	int total = Math.abs(N-i)+(i+"").length();
        	
        	if(min>total) {
        		min = total;
        	}
        	
        	
        }
        if(Math.abs(N-100)<min) {
        	min=Math.abs(N-100);
        }
        System.out.println(min);
    }
}
