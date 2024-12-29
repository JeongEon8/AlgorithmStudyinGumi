import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	static int N, C;
	static int[] houses;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);

		System.out.println(findMaxDistance(houses[N - 1]));
	}

	static int findMaxDistance(int max) {
		int left = 1, right = max;
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			// 공유기를 C개 이상 설치할 수 있는 경우
			// 인접한 두 공유기 사이의 거리를 늘려보기
			// => 우측으로
			if (check(mid)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	static boolean check(int distance) {
		int total = 1;
		long before = houses[0];
		for (int i = 1; i < N; i++) {
			long house = houses[i];
			if (house >= before + distance) {
				before = house;
				total++;
			}
		}
		return total >= C;
	}
}
