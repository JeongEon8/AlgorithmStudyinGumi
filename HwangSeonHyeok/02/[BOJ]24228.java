import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long n = Long.parseLong(st.nextToken());
		long r = Long.parseLong(st.nextToken());
		System.out.println(n + 2 * r - 1);

	}

}