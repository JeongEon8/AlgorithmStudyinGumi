import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = in.readLine();
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			String a = names[i];
			for (int j = i + 1; j < n; j++) {
				String b = names[j];
				int shortLen = Math.min(a.length(), b.length());
				for (int k = 1; k <= shortLen; k++) {
					if (a.substring(a.length() - k).equals(b.substring(0, k))) {
						ans++;
						break;
					}
					if (b.substring(b.length() - k).equals(a.substring(0, k))) {
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);

	}

}