import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = in.readLine()) != null) {
			int num = Integer.parseInt(str);
			int cnt = 1;
			int tmp = 1;
			while (tmp % num != 0) {
				cnt++;
				tmp = (tmp * 10 + 1)%num;
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}

}