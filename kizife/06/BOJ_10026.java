import java.util.Scanner;

public class BOJ_10026 {

	static int n;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int countR, countG, countB, countRG;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		map = new char[n][n];
		visit = new boolean[n][n];

		//배열 입력
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		//R구역, G구역, B구역 각각 구하기
		countR = countG = countB = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'R' && !visit[i][j]) {
					countR++;
					findR(i, j);
				}

				else if (map[i][j] == 'G' && !visit[i][j]) {
					countG++;
					findG(i, j);
				}

				else if (map[i][j] == 'B' && !visit[i][j]) {
					countB++;
					findB(i, j);
				}

			}
		}

		//모든 배열 방문 초기화
		reset();

		//적록색약이 보는 RG 구역 수 구하기
		countRG = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((map[i][j] == 'R' || map[i][j] == 'G') && !visit[i][j]) {
					countRG++;
					findRG(i, j);
				}
			}
		}

		System.out.print(countR + countG + countB + " "); //적록색약 아닌 자가 보는 구역 수
		System.out.print(countRG + countB); //적록색약이 보는 구역 수 
	}

	
	
	// 01. 적록색약이 보는 RG 공통구역의 수 
	private static void findRG(int x, int y) {
		// TODO Auto-generated method stub

		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'R' || map[nx][ny] == 'G')
					findRG(nx, ny);
			}
		}

	}

	//02. 모든 배열을 방문X로 리셋하기
	private static void reset() {
		// TODO Auto-generated method stub

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = false;
			}
		}

	}

	//03. R 구역 탐색
	private static void findR(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'R')
					findR(nx, ny);
			}
		}

	}

	//04. G 구역 탐색
	private static void findG(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'G')
					findG(nx, ny);
			}
		}

	}

	//05. B 구역 탐색
	private static void findB(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
				if (map[nx][ny] == 'B')
					findB(nx, ny);
			}
		}

	}

}
