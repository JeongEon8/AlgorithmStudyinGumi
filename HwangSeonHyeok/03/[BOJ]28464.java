import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int park = 0;
		int sung = 0;
		int parkIdx = n - 1;
		int sungIdx = 0;
		while (parkIdx >= sungIdx) {
			park += arr[parkIdx--];
			if (parkIdx < sungIdx)
				break;
			sung += arr[sungIdx++];
		}
		System.out.println(sung + " " + park);
	}

}