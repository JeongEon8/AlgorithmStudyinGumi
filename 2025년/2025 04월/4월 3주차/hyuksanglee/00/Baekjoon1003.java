package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1003 {
	static int[][] arr = new int[41][2];
	public static void main(String[] args)throws Exception {
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[2][0] = 1;
		arr[2][1] = 1;
		
		for(int i =3; i<41; i++) {
			test(i);
		}
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		for(int n = 0; n<N; n++) {
			int num = Integer.parseInt(in.readLine());
			System.out.print(arr[num][0]+" ");
			System.out.println(arr[num][1]);
			
		}
		

	}
	
	public static void test(int n) {
		arr[n][0]+= arr[n-1][0]+arr[n-2][0];
		arr[n][1]+= arr[n-1][1]+arr[n-2][1];
	}

}
