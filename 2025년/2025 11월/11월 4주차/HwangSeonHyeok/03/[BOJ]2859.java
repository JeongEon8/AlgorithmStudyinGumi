import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	static int day = 1440;
	static int week = 10080;
	static int maxCycle = 2080000;

	static long getFirstMeet(long first, long second, int firstCycle, int secondCycle) {
		if (secondCycle > firstCycle) {
			return getFirstMeet(second, first, secondCycle, firstCycle);
		}
		int cycle = 0;
		while (cycle < maxCycle) {
			long current = first + (long)firstCycle * cycle;
			if (current >= second && (current - second) % secondCycle == 0) {
				return current;
			}
			cycle++;
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(":");
		long firstStart = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]) + day * 6;
		split = in.readLine().split(":");
		long secondStart = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]) + day * 6;
		split = in.readLine().split(":");
		int firstCycle = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		split = in.readLine().split(":");
		int secondCycle = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		long ans = -1;
		ans = getFirstMeet(firstStart, secondStart, firstCycle, secondCycle);

		if (ans == -1) {
			System.out.println("Never");
		} else {
			System.out.println(dayOfWeek[(int) (ans / day % 7)]);
			int time = (int) (ans % day);
			int hour = time / 60;
			int minute = time % 60;
			String timeFormat = String.format("%02d:%02d", hour, minute);
			System.out.println(timeFormat);

		}

	}

}