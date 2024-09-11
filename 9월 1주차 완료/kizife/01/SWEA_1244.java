import java.util.Scanner;

public class Solution {

	static String[] arr;
	static int chance, max; // swap 기회
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {

			arr = sc.next().split("");
			chance = sc.nextInt();

			max = 0;
			
			// swap 기회가 arr 길이를 초과할 경우, arr 길이만큼만
			if (arr.length < chance) {
				chance = arr.length;
			}

			dfs(0, 0);

			System.out.println("#" + i + " " + max);

		}

	}

	private static void dfs(int start, int count) {

		// 기회만큼 실행했을 경우, 그만둔다
		if (count == chance) {
			String result = "";
			for (String s : arr)
				result += s;
			max = Math.max(max, Integer.parseInt(result));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				String s = arr[i];
				arr[i] = arr[j];
				arr[j] = s;

				dfs(i, count + 1);

				s = arr[i];
				arr[i] = arr[j];
				arr[j] = s;
			}
		}

	}

}
