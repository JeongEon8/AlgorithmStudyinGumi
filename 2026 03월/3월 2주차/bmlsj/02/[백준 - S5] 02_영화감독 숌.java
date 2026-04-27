import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int num = 666;
		int cnt = 0;
		while (true) {

			if (String.valueOf(num).contains("666")) {
				cnt++;
			}

			if (cnt == N) {
				System.out.println(num);
				break;
			}
			
			num++;
		}
	}

}