package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Beakjoon14502 {

	static int N, M, max;

	static int[][] map;
	
	
	
	static int[] dn = { 0, 1, 0, -1 };
	static int[] dm = { 1, 0, -1, 0 };

	// 바이러스의 위치를 담는 리스트
	static ArrayList<Virus> vi = new ArrayList<>();

	// 벽 방문 여부
	static boolean[][] wallSelected;
	// 바이러스 방문 여부
		static boolean[][] virusSelected;

	
	

	// 바이러스 위치를 담는 클래스
	static class Virus {
		int width; // 가로
		int height; // 세로
	}

	public static int virusBfs(int u) {
		virusSelected = new boolean[N][M]; // 바이러스 방문확인 하는 배열 초기화
		Queue<Virus> que = new ArrayDeque<>();
		for (Virus vir : vi) {
			que.offer(vir);
		}
		while (!que.isEmpty()) {
			Virus vir = que.poll();
			int n = vir.height; // 세로 위치
			int m = vir.width; // 가로 위치
			
			// 4방향 확인
			for(int d =0; d<4; d++) {
				int cn = n+dn[d];
				int cm = m+dm[d];
				if(cn<0 || cm<0 || cn>=N || cm>= M) { // 지도밖으로 벗어날떄
					continue;
				}
				if(map[cn][cm]==0 && virusSelected[cn][cm]==false) {
					u+=1;
					virusSelected[cn][cm]=true;
					Virus vir1 = new Virus();
					vir1.height=cn;
					vir1.width=cm;
					que.offer(vir1);
				}
			}

		}
		return u;
	}

	// 벽 3개 세우는 dfs
	public static void wall(int n, int m, int count, int unit) {
		if (count == 3) {
			int total = virusBfs(unit);
			total = (N*M)-total;
			if(max<total) {
				max=total;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wallSelected[i][j] == false && map[i][j] == 0) {
					wallSelected[i][j] = true; // 방문체크
					map[i][j] = 1; // 벽생성
					wall(i, j, count + 1,unit);
					wallSelected[i][j] = false; // 방문체크 해제
					map[i][j] = 0; // 벽복구
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 세로 크기
		M = Integer.parseInt(input[1]); // 가로 크기

		map = new int[N][M]; // 연구소 지도 크기에 맞게 배열 초기화
		wallSelected = new boolean[N][M]; // 벽 방문확인 하는 배열 초기화
		max =Integer.MIN_VALUE;
		
		int unit = 3; // 바이러스나 벽 총합변수 벽3개 미리 초기화

		// 지도에 바이러스와 벽 표시
		for (int n = 0; n < N; n++) {
			input = in.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(input[m]);
				if (Integer.parseInt(input[m]) == 2) { // 바이러스이면
					unit += 1; // 바이러스나 벽 변수 +1
					Virus vir = new Virus();
					vir.width = m; // 바이러스의 가로위치
					vir.height = n; // 바이러스의 세로위치
					vi.add(vir); // 리스트에 바이러스 정보 담기
				}
				if (Integer.parseInt(input[m]) == 1) {
					unit += 1; // 바이러스나 벽 변수 +1
				}
			}
		}

		// 벽 세우기
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 0) {
					wallSelected[n][m] = true;
					map[n][m] = 1;// 벽 생성
					wall(n, m, 1, unit);
					map[n][m] = 0;// 벽 복구
				}
			}
		}
		
		System.out.println(max);

		// map안에 내용 확인
//		for(int n = 0; n<N; n ++) {
//			System.out.println(Arrays.toString(map[n]));
//		}

	}

}
