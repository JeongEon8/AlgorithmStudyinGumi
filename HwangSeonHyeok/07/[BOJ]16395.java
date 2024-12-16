import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] pascal = new int [32][32];
		pascal[1][1] = 1;
		for(int i = 2;i<31;i++) {
			for(int j = 1; j<=i;j++) {
				pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
			}
		}
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		System.out.println(pascal[n][k]);
				
	}

}