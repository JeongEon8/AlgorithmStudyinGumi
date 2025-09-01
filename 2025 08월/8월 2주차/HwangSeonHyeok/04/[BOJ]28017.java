import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] clearTime = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				clearTime[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int firstIdx = 0;
		int firstTime = 10001;
		int secondTime = 10001;
		for (int i = 0; i < m; i++) {
			if (clearTime[0][i] < firstTime) {
				secondTime = firstTime;
				firstTime = clearTime[0][i];
				firstIdx = i;
			} else if (clearTime[0][i] < secondTime && clearTime[0][i] >= firstTime) {
				secondTime = clearTime[0][i];
			}
		}
		for (int i = 1; i < n; i++) {
			int tmpFirstIdx = 0;
			int tmpFirstTime = secondTime + 10001;
			int tmpSecondTime = secondTime + 10001;
			for (int j = 0; j < m; j++) {
				int currentTime = (j != firstIdx) ? firstTime + clearTime[i][j] : secondTime + clearTime[i][j];
				if (currentTime < tmpFirstTime) {
					tmpSecondTime = tmpFirstTime;
					tmpFirstTime = currentTime;
					tmpFirstIdx = j;
				} else if (currentTime < tmpSecondTime && currentTime >= tmpFirstTime) {
					tmpSecondTime = currentTime;
				}
			}
			firstIdx = tmpFirstIdx;
			firstTime = tmpFirstTime;
			secondTime = tmpSecondTime;

		}
		System.out.println(firstTime);

	}

}