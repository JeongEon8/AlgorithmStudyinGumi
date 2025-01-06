import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr= new int[n];
		for(int i = 0; i<n;i++) {
			String[] split = in.readLine().split(" ");
			arr[i] = Integer.parseInt(split[0]) - Integer.parseInt(split[1]);  
		}
		Arrays.sort(arr);
		int ans = arr[n/2]-arr[(n-1)/2]+1;
		System.out.println(ans);
	}
}