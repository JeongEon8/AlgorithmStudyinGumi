package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Sw4013 {

	static int[][] magnet;
	static int[] point;
	static String[] input;
	static Queue<Integer> left;
	static Queue<Integer> right;

	// 자석의 연결 상태 확인
	public static void check(int m, int t) { // m : 자석 번호, t : 확인하려는 자석이 오른쪽인지 왼쪽인지
		if (t == 0) { // 0 : 왼쪽
			if (m > 0) { // 왼쪽은 1이상일때만 확인 (0일경우 왼쪽에 자석이 없다)

				int cp = point[m]; // 현재 자석의 빨간색 화살표 위치
				int cpe = (cp + 6) % 8; // 현재 자석의 왼쪽 날 위치;

				int np = point[m - 1]; // 왼쪽 자석의 빨간색 화살표 위치
				int npe = (np + 2) % 8; // 왼쪽 자석의 오른쪽 날 위치

				if (magnet[m][cpe] != magnet[m - 1][npe]) { // 외쪽 자석과 다른 극인지 확인
					left.offer(m - 1);
					check(m - 1, 0);
				}
			}
		} else { // 오른쪽일 경우
			if (m < 3) { // 오른쪽은 2이하일때만 확인 (3일경우 오른쪽에 자석이 없다)

				int cp = point[m]; // 현재 자석의 빨간색 화살표 위치
				int cpe = (cp + 2) % 8; // 현재 자석의 오른쪽 날 위치;

				int np = point[m + 1]; // 오른쪽 자석의 빨간색 화살표 위치
				int npe = (np + 6) % 8; // 오른쪽 자석의 왼쪽 날 위치

				if (magnet[m][cpe] != magnet[m + 1][npe]) { // 외쪽 자석과 다른 극인지 확인
					right.offer(m + 1);
					check(m + 1, 1);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 테이스 케이스 횟수 받기
		int T = Integer.parseInt(in.readLine());

		// 테이스 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {

			magnet = new int[4][8]; // 자석의 개수 : 4개 , 날의 개수 : 8개
			point = new int[4]; // 각 자석의 빨간색 화살표 위치 담는 배열

			int K = Integer.parseInt(in.readLine()); // 회전 횟수

			// 4개의 자석 정보 받아서 배열에 넣기
			for (int m = 0; m < 4; m++) { // 자석의 개수 만큼 반복
				String[] input = in.readLine().split(" "); // 각 자석의 날 정보 받기
				for (int e = 0; e < 8; e++) { // 날의 개수 만큼 반복
					magnet[m][e] = Integer.parseInt(input[e]); // 해당 자석의 날 정보 배열에 담기

				}
			}

			// K만큼 반복
			for (int k = 0; k < K; k++) {

				left = new ArrayDeque<>(); // 왼쪽에 연결된 자석 받는 큐 초기화
				right = new ArrayDeque<>(); // 오른쪽에 연결된 자석 받는 큐 초기화

				input = in.readLine().split(" "); // 자석의 번호와 회전 방향 정보 받기
				int M = Integer.parseInt(input[0])-1; // M : 자석의 번호
				int D = Integer.parseInt(input[1]); // D : 회전 방향
				D *= -1; // 빨간색 화살표를 이동시키는 거라 방향을 바꾸어준다.

				check(M, 0); // 왼쪽 확인
				check(M, 1); // 오른쪽 확인
				
				point[M] = (point[M] + 8 + D) % 8;

				int tmp = D; // 회전방향 복사

				// 왼쪽 연결된 자석 이동시키기
				while (!left.isEmpty()) {
					tmp *= -1;
					int nm = left.poll(); // 연결된 자석 하나씩 뽑기
					point[nm] = (point[nm] + 8 + tmp) % 8; // 음수가 나올수 있어서
				}

				tmp = D; // 회전방향 복사
				

				// 오른쪽 연결된 자석 이동시키기
				while (!right.isEmpty()) {
					tmp *= -1;
					int nm = right.poll(); // 연결된 자석 하나씩 뽑기
					point[nm] = (point[nm] + 8 + tmp) % 8; // 음수가 나올수 있어서
				}

			}
			
			int result = 0;
			
			// 자석의 빨간색 화살표 위치 극 확인
			for(int p = 0; p<point.length; p++) {
				int rp = point[p];
				if(magnet[p][rp] == 1) {
					result += 1<<p;
				}
			}
			
			System.out.println("#"+t+" "+result);
			

		}
	}

}
