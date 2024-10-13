import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Serial implements Comparable<Serial> {
		int sum = 0;
		String serial;

		public Serial(String serial) {
			super();
			this.serial = serial;
			for (int i = 0; i < serial.length(); i++) {
				int cNum = serial.charAt(i) - '0';
				if (cNum > 0 && cNum <= 9) {
					sum += cNum;
				}
			}
		}

		@Override
		public int compareTo(Serial o) {
			if (this.serial.length() != o.serial.length()) {
				return this.serial.length() - o.serial.length();
			} else if (this.sum != o.sum) {
				return this.sum - o.sum;
			}
			return this.serial.compareTo(o.serial);
		}

	}

	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Serial[] sArr = new Serial[n];
		for (int i = 0; i < n; i++) {
			sArr[i] = new Serial(in.readLine());
		}
		Arrays.sort(sArr);
		for (int i = 0; i < n; i++) {
			sb.append(sArr[i].serial + "\n");
		}
		System.out.println(sb);

	}

}