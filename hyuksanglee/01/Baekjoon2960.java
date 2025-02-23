package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2960 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] arr = new int[N+1];
		arr[0]= 1;
		arr[1] =1;
		while(K>0) {
			for(int i=2; i<N+1; i++) {
				if(arr[i]!=0) {
					continue;
				}
				for(int j =1; j*i<N+1; j++) {
					if(arr[j*i]==0) {
						K--;
						arr[j*i]=1;
						if(K==0) {
							System.out.print(j*i);
							break;
						}
					}
				}
			}
		}

	}

}
