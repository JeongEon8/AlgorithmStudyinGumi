package HongJun.07_[백준]2961;
import java.util.*;
import java.io.*;

public class BOJ_2961 {
    private static int N;
	private static int S;		// 신맛
	private static int B;		// 쓴맛
	private static int[][] taste;	// 음식 목록
	static boolean[] isSelected;	// 부분집합 구성에 포함됐는지 여부
	private static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		taste = new int[N][2];
		isSelected = new boolean[N];
		
		for (int i = 0; i< N; i++) {
			String[] s = in.readLine().split(" ");
			S = Integer.parseInt(s[0]);
			B = Integer.parseInt(s[1]);
			
			taste[i][0] = S;
			taste[i][1] = B;
			
		}
		subset(0);
		System.out.println(MIN);
	}

	// 재료의 부분 집합
	private static void subset(int cnt) {
		// 기저 부분
		// 다 선택 했을 때
		if (cnt == N) {
			int result = getTaste();
			MIN = Math.min(MIN, result);
			return;
			
		}
		
		// 유도 부분
		// 현재 원소를 부분 집합에 포함
		isSelected[cnt] = true;
		subset(cnt + 1);
		
		// 부분 집합에 미 포함
		isSelected[cnt] = false;
		subset(cnt+1);
	}
	
	private static int getTaste() {
		int sour = 1;
		int bitter = 0;
		
		for (int i = 0; i<N; i++) {
			if (isSelected[i]) {
				sour *= taste[i][0];
				bitter += taste[i][1];
			}
		}
		
		// getTaste가 한번 더 돌 때 방지
		if (sour == 1 && bitter == 0) {
			return Integer.MAX_VALUE;
		}
		return Math.abs(sour - bitter);
	}
}
