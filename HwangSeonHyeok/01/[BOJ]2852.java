import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int timeToInt(String time) {
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}

	public static String intToTime(int num) {
		int hour = num / 60;
		int minute = num % 60;
		return String.format("%02d:%02d", hour, minute);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] goalTimes = new int[n];
		boolean[] isTeamOne = new boolean[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int team = Integer.parseInt(st.nextToken());
			goalTimes[i] = timeToInt(st.nextToken());
			if (team == 1) {
				isTeamOne[i] = true;
			}
		}
		int scoreOne = isTeamOne[0] ? 1 : 0;
		int scoreTwo = isTeamOne[0] ? 0 : 1;
		int winningTimeOne = 0;
		int winningTimeTwo = 0;
		for (int i = 1; i < n; i++) {
			if (scoreOne > scoreTwo) {
				winningTimeOne += goalTimes[i] - goalTimes[i - 1];
			} else if (scoreTwo > scoreOne) {
				winningTimeTwo += goalTimes[i] - goalTimes[i - 1];
			}
			if (isTeamOne[i]) {
				scoreOne++;
			} else {
				scoreTwo++;
			}
		}
		if (scoreOne > scoreTwo) {
			winningTimeOne += 48 * 60 - goalTimes[n - 1];
		} else if (scoreOne < scoreTwo) {
			winningTimeTwo += 48 * 60 - goalTimes[n - 1];
		}

		System.out.println(intToTime(winningTimeOne));
		System.out.println(intToTime(winningTimeTwo));
	}

}