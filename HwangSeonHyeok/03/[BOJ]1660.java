import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int tmp = 0;
		int[] dp = new int[122];
		for(int i = 0; i<=121;i++) {
			tmp+= i*(i+1)/2;
			dp[i] = tmp;
		}
		int[] ans = new int[n+1];
		ans[0] = 0;
		ans[1] = 1;
		for(int i = 2;i<=n;i++) {
			ans[i]= Integer.MAX_VALUE;
		}
		for(int i = 2; i<=n;i++) {
			for(int j = 1; j<n;j++) {
				if(dp[j]>i) {
					break;
				}
				ans[i] = Math.min(ans[i],ans[i-dp[j]]+1);
			}
		}
		System.out.println(ans[n]);

	}

}