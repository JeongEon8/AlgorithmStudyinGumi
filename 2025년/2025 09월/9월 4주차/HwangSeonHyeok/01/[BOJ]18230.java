import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		Integer[] half = new Integer[a];
		for (int i = 0; i < a; i++) {
			half[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		Integer[] whole = new Integer[b];
		for (int j = 0; j < b; j++) {
			whole[j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(half, Collections.reverseOrder());
		Arrays.sort(whole, Collections.reverseOrder());
		int remain = n;
		int hIdx = 0;
		int wIdx = 0;
		int ans = 0;
		if (remain % 2 == 1) {
			ans += half[hIdx++];
			remain--;
		}
		while (remain > 0) {
			int doubleHalfValue = (hIdx < a - 1) ? half[hIdx] + half[hIdx + 1] : -1;
			int wholeValue = (wIdx < b) ? whole[wIdx] : -1;
			if (doubleHalfValue >wholeValue) {
				ans += doubleHalfValue;
				hIdx += 2;
				remain -= 2;
			} else {
				ans += wholeValue;
				wIdx++;
				remain -= 2;
			}
		}
		System.out.println(ans);
	}

}