import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		String[] sub = line.split("-");
		int ans = 0;

		for(int i = 0; i < sub.length; i++) {

			int sum = 0;
			String[] add = sub[i].split("\\+");
			for(int j = 0; j < add.length; j++) {
				sum += Integer.parseInt(add[j]);
			}

			if (i == 0) ans += sum;
			else ans -= sum;

		}

		System.out.println(ans);

	}

}