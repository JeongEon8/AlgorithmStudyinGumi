import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// 반드시 0이 하나 있고, 모든 자리수의 합이 3의 배수
		boolean zeroCheck = false;
		int digit = 0, idx = 0;
		int[] numList = new int[input.length()];
		for (char num : input.toCharArray()) {
			if (num == '0') {
				zeroCheck = true;
			}
			numList[idx++] = num - '0';
			digit += num - '0';
		}

		if (!zeroCheck)
			System.out.println("-1");
		else if (digit % 3 != 0) {
			System.out.println("-1");
		} else {
			Arrays.sort(numList);

			for (int i = numList.length - 1; i >= 0; i--) {
				System.out.print(numList[i]);
			}
		}

	}

}