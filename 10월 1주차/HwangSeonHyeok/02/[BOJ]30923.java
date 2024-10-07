import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		String[] split = in.readLine().split(" ");
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		long ans = 0;
		if(n==1) {
			ans+=arr[0]*4+2;
		}else {
			ans+=arr[0]*3+Math.max(arr[0]-arr[1],0)+2;
			for(int i = 1; i<n-1; i++) {
				ans+=arr[i]*2+Math.max(arr[i]-arr[i+1],0)+Math.max(arr[i]-arr[i-1],0)+2;
			}
			ans+=arr[n-1]*3+Math.max(arr[n-1]-arr[n-2],0)+2;
		}
		System.out.println(ans);
	}

}