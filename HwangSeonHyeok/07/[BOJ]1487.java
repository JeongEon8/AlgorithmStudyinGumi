import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static class Customer {
		int price, fee;

		public Customer(int price, int fee) {
			super();
			this.price = price;
			this.fee = fee;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Customer[] customerArr = new Customer[n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			customerArr[i] = new Customer(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		}
		int ans = 0;
		int maxbenefit = 0;
		for (int i = 0; i < n; i++) {
			int price = customerArr[i].price;
			int benefit = 0;
			for (int j = 0; j < n; j++) {
				Customer customer = customerArr[j];
				if (price <= customer.price && price > customer.fee) {
					benefit += price - customer.fee;
				}
			}
			if (maxbenefit < benefit || (maxbenefit == benefit && price < ans)) {
				maxbenefit = benefit;
				ans = price;
			}
		}
		System.out.println(ans);
	}

}