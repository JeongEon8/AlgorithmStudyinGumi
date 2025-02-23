import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int b = Integer.parseInt(split[0]);
		int c = Integer.parseInt(split[1]);
		int d = Integer.parseInt(split[2]);
		int[] burger = new int[b];
		int[] side = new int[c];
		int[] beverage = new int[d];
		int total = 0;
		split = in.readLine().split(" ");
		for (int i = 0; i < b; i++) {
			burger[i] = -Integer.parseInt(split[i]);
			total -= burger[i];
		}
		split = in.readLine().split(" ");
		for (int i = 0; i < c; i++) {
			side[i] = -Integer.parseInt(split[i]);
			total -= side[i];
		}
		split = in.readLine().split(" ");
		for (int i = 0; i < d; i++) {
			beverage[i] = -Integer.parseInt(split[i]);
			total -= beverage[i];
		}
		Arrays.sort(burger);
		Arrays.sort(side);
		Arrays.sort(beverage);
		int min = Math.min(b, Math.min(c, d));
		int sale = 0;
		for (int i = 0; i < min; i++) {
			int set = (int) ((burger[i] + side[i] + beverage[i]) * 0.9);
			sale -= set;
		}
		for (int i = min; i < b; i++) {
			sale -= burger[i];
		}
		for (int i = min; i < c; i++) {
			sale -= side[i];
		}
		for (int i = min; i < d; i++) {
			sale -= beverage[i];
		}
		System.out.println(total);
		System.out.println(sale);
	}

}