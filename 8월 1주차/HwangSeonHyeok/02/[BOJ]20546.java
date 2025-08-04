import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[14];
		for (int i = 0; i < 14; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int bnpMoney = n;
		int bnpStock = 0;
		int timingMoney = n;
		int timingStock = 0;
		int timingTrend = 0;
		int firstPrice = arr[0];
		if (firstPrice <= bnpMoney) {
			bnpStock += bnpMoney / firstPrice;
			bnpMoney -= firstPrice * (bnpMoney / firstPrice);
		}
		for (int i = 1; i < 14; i++) {
			int currentPrice = arr[i];
			if (currentPrice <= bnpMoney) {
				bnpStock += bnpMoney / currentPrice;
				bnpMoney -= currentPrice * (bnpMoney / currentPrice);
			}
			if (currentPrice == arr[i - 1])
				timingTrend = 0;
			else if (currentPrice < arr[i - 1]) {
				timingTrend = Math.min(-1, timingTrend - 1);
			} else if (currentPrice > arr[i - 1]) {
				timingTrend = Math.max(1, timingTrend + 1);
			}
			if (timingTrend >= 3) {
				timingMoney += timingStock * currentPrice;
				timingStock = 0;
			} else if (timingTrend <= -3) {
				timingStock += timingMoney / currentPrice;
				timingMoney -= currentPrice * (timingMoney / currentPrice);
			}
		}

		int bnpTotal = bnpMoney + bnpStock * arr[13];
		int timingTotal = timingMoney + timingStock * arr[13];
		if (bnpTotal == timingTotal) {
			System.out.println("SAMESAME");
		} else if (bnpTotal > timingTotal) {
			System.out.println("BNP");
		} else {
			System.out.println("TIMING");
		}

	}

}