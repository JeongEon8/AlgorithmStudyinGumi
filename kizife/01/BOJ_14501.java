import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] T;
	static int[] P;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//여기는 그냥 입력 받는 부분
		//상담소요기간 T와 금액P를 담을 배열 정의 
		N = sc.nextInt();
		T = new int[N + 1];
		P = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		calculateMax(1, 0);
		System.out.println(max);

	}

	public static void calculateMax(int day, int profit) {

		if (day > N) {
			max = Math.max(max, profit);
			return;
		} //현재날짜가 N을 초과하면 최대수익을 갱신한 채로 함수 종료함.

		calculateMax(day + 1, profit); //상담을 하지 않는 경우, 다음날(day+1)로 넘어가면서 현재수익 그대로 유지

		if (day + T[day] - 1 <= N) {
			// day+T[day]라는 것은, 현재날짜(day)로부터 상담가능한 다음날짜(+T[day)임 
			calculateMax(day + T[day], profit + P[day]);
			// 상담 가능한 다음 날짜를 구하고, 이익 또한 갱신함. 
		}
	}
}
