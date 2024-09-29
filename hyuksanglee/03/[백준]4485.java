package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class baekjoon4485 {

	public static int[][] map;
	public static int[][] move;
	public static int[] di = { 0, 1, 0, -1 };
	public static int[] dj = { 1, 0, -1, 0 };
	public static int N;

	public static class Rupee {

		int i; // i좌표
		int j; // j 좌표
		int rupee; // 루피
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine()); // N 입력받기
		
		int count = 0;

		while (N != 0) { // 사용자가 0입력하기 전까지 반복
			count++;

			map = new int[N][N]; // 해당칸에 루피를 저장하는 배열 초기화
			move = new int[N][N];

			// 동굴 해당 칸에 루피 크기 입력
			for (int i = 0; i < N; i++) {
				String[] input = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					move[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int a = bfs();
			System.out.println("Problem "+count+": "+a);

//			for(int i = 0; i<N; i++) {
//				System.out.println( Arrays.toString(map[i]));
//			}

			N = Integer.parseInt(in.readLine()); //
		}

	}

	public static int bfs() {
		Queue<Rupee> que = new ArrayDeque();
		Rupee je = new Rupee();
		je.i = 0;
		je.j = 0;
		je.rupee = map[0][0];
		move[0][0] = je.rupee;

		que.add(je);
		while (!que.isEmpty()) {
			je = que.poll();
			int i = je.i;
			int j = je.j;
			int rupee = je.rupee;

			// 주변 탐색
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni<0 || nj <0 || ni>=N || nj>=N) {
					continue;
				}
				if(move[ni][nj] > rupee+map[ni][nj]) {
					move[ni][nj] = rupee+map[ni][nj];
					Rupee jelda = new Rupee();
					jelda.i =ni;
					jelda.j = nj;
					jelda.rupee = move[ni][nj];
					que.add(jelda);
				}
				
			}

		}
		return move[N-1][N-1];

	}

}
