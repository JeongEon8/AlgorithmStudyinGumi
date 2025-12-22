import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		System.out.println(n * (n + 1) / 2);
	}

}