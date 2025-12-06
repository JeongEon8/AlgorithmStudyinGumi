import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int[] num1 = new int[2];
		int[] num2 = new int[2];

		for (int i = 0; i < 2; i++) {
			num1[i] = Integer.parseInt(split[i]);
		}

		split = br.readLine().split(" ");
		num2[0] = Integer.parseInt(split[0]);
		num2[1] = Integer.parseInt(split[1]);

		int a = num1[0] * num2[1] + num2[0] * num1[1];
		int b = num2[1] * num1[1];

		while (true) {
			boolean check = false;
			for (int i = 2; i <= Math.max(a, b); i++) {
				if (a % i == 0 && b % i == 0) {
					a /= i;
					b /= i;
					check = true;
					break;
				}
			}
			
			if (!check) break;
		}

		System.out.println(a + " " + b);
	}

}
