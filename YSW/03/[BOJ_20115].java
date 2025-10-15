import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20115 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		double[] drink = new double[N];

		for (int i = 0; i < drink.length; i++) {
			drink[i] = Double.parseDouble(strArr[i]);
		}

		Arrays.sort(drink);

		for (int i = 0; i < drink.length - 1; i++) {
			drink[N - 1] += drink[i] / 2;
		}

		System.out.println(drink[N - 1]);
	}

}
