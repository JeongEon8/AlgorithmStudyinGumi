import java.util.Arrays;

public class BOJ_4673 {
	static final int N = 10_001;
	static boolean[] checkSelfNumber; // 셀프 넘버 확인용 배열

	public static void main(String[] args) {
		checkSelfNumber = new boolean[N];
		for (int i = 1; i < N; i++) {
			int num = i;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				num += str.charAt(j) - '0';
			}
			if (num < N)
				checkSelfNumber[num] = true; // 생성자가 있음을 표시하기
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			// 셀프 넘버이면 출력하기
			if (!checkSelfNumber[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
