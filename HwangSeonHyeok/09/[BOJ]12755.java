import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String nstr = in.readLine();
		int n = Integer.parseInt(nstr);
		int num = 1;
		int subdigit = 9;
		while (n > subdigit) {
			n -= subdigit;
			subdigit = (int) Math.pow(10, num++) * num * 9;
		}
		n--;
		int cnt = (int) Math.pow(10, num - 1) + n / num;
		String strCnt = Integer.toString(cnt);
		char ans = strCnt.charAt(n % num);
		System.out.println(ans);

	}

}