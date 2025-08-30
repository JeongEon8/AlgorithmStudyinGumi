import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_25379 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		String[] strArr = br.readLine().split(" ");

		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(strArr[i]) % 2;
		}

		int min = Integer.MAX_VALUE;
		int count = 0;
		int sum = 0;
		int currentIndex = -1;

		// 0 짝수를 전부 왼쪽
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				if (currentIndex != -1) {
					sum += count;
				}
			} else {
				if (currentIndex == -1) {
					currentIndex = i;
				}
				count++;
			}
		}
		min = sum;
		sum = 0;
		count = 0;

		// 0 짝수를 전부 오른쪽
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				if (currentIndex != -1) {
					sum += count;
				}
			} else {
				if (currentIndex == -1) {
					currentIndex = i;
				}
				count++;
			}
		}

		if (min > sum) {
			min = sum;
		}

		System.out.println(min);
	}
}