import java.util.Scanner;

public class BOJ_5582 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		int result = 0; //길이 저장 변수 

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) { // 두 문자가 같으면
					dp[i][j] = dp[i - 1][j - 1] + 1; // 이전의 공통 부분 문자열 길이에 1을 더한다.
					if (dp[i][j] > result)
						result = dp[i][j]; 
				} else { // 공통부분 없으면 0으로 초기화 
					dp[i][j] = 0;
				}
			}
		}
		
		System.out.println(result);

	}

}
