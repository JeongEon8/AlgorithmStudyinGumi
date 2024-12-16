import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long[] arr = new long[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		Arrays.sort(arr);
		int max = 1;
		long ans = arr[0];
		int cnt = 1;
		for(int i = 1; i<n;i++ ) {
			if(arr[i]!=arr[i-1]) {
				if(cnt>max) {
					max = cnt;
					ans = arr[i-1];
				}
				cnt=0;
				
			}
			cnt++;
		}
		if(cnt>max) {
			ans = arr[n-1];
		}
		System.out.println(ans);

	}

}