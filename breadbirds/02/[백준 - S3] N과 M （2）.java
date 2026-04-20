import java.util.Scanner;

public class Main {
	static int N,M;
	static int answer[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 1~N 이 순서대로, 이중에서 M개 고름.
		// 오름차순 
		
		// M개 고를거니까 M
		answer = new int [M];
		// 조합
		combination(1,0);
		
	}

	private static void combination(int start, int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
            return;
		}
		
		for (int i = start; i <= N; i++) {
            answer[depth] = i; // 현재 자리에 숫자 i 선택
            combination(i + 1, depth + 1); // 다음 자리로 넘어감 (i+1부터 시작)
        }
		
	}

}