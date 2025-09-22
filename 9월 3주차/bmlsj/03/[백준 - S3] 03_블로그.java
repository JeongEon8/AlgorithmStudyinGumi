import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int X = Integer.parseInt(split[1]);

		int[] visit = new int[N];

		split = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			visit[i] = Integer.parseInt(split[i]);
		}

		int sum = 0;
		// 처음 X일 합
		for (int i = 0; i < X; i++) {
		    sum += visit[i];
		}
		int max = sum;
		int count = 1;

		// 슬라이딩
		for (int i = X; i < N; i++) {
		    sum = sum - visit[i - X] + visit[i];
		    if (sum > max) {
		        max = sum;
		        count = 1;
		    } else if (sum == max) {
		        count++;
		    }
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}

	}

}