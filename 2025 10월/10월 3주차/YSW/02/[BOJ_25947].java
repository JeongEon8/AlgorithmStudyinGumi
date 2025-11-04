import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_25947 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int n = Integer.parseInt(strArr[0]);
		long budget = Integer.parseInt(strArr[1]);
		int numberOfDiscount = Integer.parseInt(strArr[2]);
		Long[] asendingPrice = new Long[n];
		int count = 0;

		strArr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			asendingPrice[i] = Long.parseLong(strArr[i]);
		}

		Arrays.sort(asendingPrice);

		int index = 0;

		for (int i = 0; i < n; i++) {
			long halfPrice = asendingPrice[i] / 2;
			if (count < numberOfDiscount) {
				if (budget >= halfPrice) {
					budget -= halfPrice;
					count++;
				} else {
					break;
				}
			} else {
				if (budget >= halfPrice + asendingPrice[index] / 2) {
					budget -= (halfPrice + asendingPrice[index] / 2);
					index++;
					count++;
				} else {
					break;
				}
			}
		}

		System.out.println(count);
	}

}

