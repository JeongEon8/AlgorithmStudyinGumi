import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_8989 {
	public static class Angle {
		int hour;
		int minute;
		int second;
		double angle;

		public Angle(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
			this.second = hour * 3600 + minute * 60;
			this.angle = calcAngle(hour, minute);
		}

		private double calcAngle(int hour, int minute) {
			double ang = Math.abs(30 * (hour % 12) - 5.5 * minute);
			return ang > 180 ? 360 - ang : ang;
		}

		public double getAngle() {
			return angle;
		}

		public int getSecond() {
			return second;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			String[] strArr = br.readLine().split(" ");
			Angle[] angles = new Angle[5];
			for (int i = 0; i < strArr.length; i++) {
				String[] time = strArr[i].split(":");
				int h = Integer.parseInt(time[0]);
				int m = Integer.parseInt(time[1]);
				angles[i] = new Angle(h, m);
			}

			Arrays.sort(angles, Comparator.comparing(Angle::getAngle).thenComparing(Angle::getSecond));
			System.out.printf("%02d:%02d\n", angles[2].hour, angles[2].minute);
		}
	}

}
