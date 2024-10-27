import java.util.Scanner;

public class BOJ_4673 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10000];

		for (int i = 0; i < 10000; i++) {
			int a = d(i + 1); 

			if (a <= 10000) { //결과가 10000 이하일 시 
				arr[a - 1] = 1; //생성자 있으면 1로 지정 
			}
		}

		for (int i = 0; i < 10000; i++) { 
			if (arr[i] == 0) { //생성자 없는 수만 출력함 
				System.out.println(i + 1); 
			}
		}
	}

	private static int d(int num) {

		int sum = num;
		while (num != 0) {
			sum += num % 10; //각 자리수 더함 
			num = num / 10; //다음 자리수로 이동함 
		}
		return sum;
	}

}
