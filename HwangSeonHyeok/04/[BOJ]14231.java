import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] arr = new int[n];
		int[] dp = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		int ans = 1;
		for(int i = 0; i<n;i++) {
			dp[i] = 1;
			for(int j = 0; j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			if(dp[i]>ans) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
		
		

	}

}