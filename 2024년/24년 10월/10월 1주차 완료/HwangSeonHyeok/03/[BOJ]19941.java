import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		String str = in.readLine();
		int[] arr = new int[n+1];//0은 사람 1은 버거 2는 버거먹고 남은자리.
		for (int i = 0; i < n; i++) {
			if(str.charAt(i)=='H') {
				arr[i] = 1;
			}
		}
		int ans = 0;
		for(int i = 0; i<n;i++) {
			if(arr[i]!=0)continue;
			for(int j = Math.max(i-k,0);j<=Math.min(i+k,n-1);j++) {
				if(arr[j]==1) {
					ans++;
					arr[j] = 2;
					break;
				}
			}
		}
		System.out.println(ans);
	
	}

}