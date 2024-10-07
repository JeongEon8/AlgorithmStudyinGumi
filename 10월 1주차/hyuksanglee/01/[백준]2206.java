package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class baekjoon2206 {

	// 방문 처리
	public static boolean[][][] isSelected;
	// 맵정보
	public static int[][] arr;
	// 맵의 가로 세로 길이
	public static int N, M;

	// 상하좌우 이동
	public static int[] di = { 1, 0, -1, 0 };
	public static int[] dj = { 0, 1, 0, -1 };

	// 현제 위치 정보
	public static class Data {
		int i;
		int j;
		int skill;
		int count;
	}

	// bfs 탐색
	public static int bfs() {
		
		Queue<Data> que = new ArrayDeque();
		Data data = new Data();
		data.i = 0;
		data.j = 0;
		data.skill = 0;
		data.count = 1;
		que.add(data);

		while (!que.isEmpty()) {
			data = que.poll();
			int ci = data.i;
			int cj = data.j;
			int cskill = data.skill;
			int ccount = data.count;
			
			// 도착 지점에 도달했을때 이동 횟수 리턴
			if(ci==N-1 && cj == M-1) {
				return ccount;
			}
			
			// 4방향 탐색
			for(int d =0; d<4; d++) {
				int ni = ci+di[d];
				int nj = cj+dj[d];
				
				// 맵 밭으로 벗어 날경우
				if(ni <0 || nj <0 || ni>=N || nj>=M) {
					continue;
				}
			
				
				// 이동할 구역이 0이 아니고 방문 안할경우 해당 큐에 담기
				if(arr[ni][nj]==0 && isSelected[ni][nj][cskill]==false) {
					isSelected[ni][nj][cskill]=true;
					Data ndata = new Data();
					ndata.i = ni;
					ndata.j = nj;
					ndata.skill = cskill;
					ndata.count = ccount+1;
					que.add(ndata);
				}else if(arr[ni][nj]==1 && cskill==0 && isSelected[ni][nj][cskill+1]==false) {	// 이동할 구역이 1이면서 벽부수기를 한번도 안 했을 경우 해당 지역 큐에 담기
					isSelected[ni][nj][cskill+1]=true;
					Data ndata = new Data();
					ndata.i = ni;
					ndata.j = nj;
					ndata.skill = cskill+1;
					ndata.count = ccount+1;
					que.add(ndata);
				}
				
			
				
				
			}

		}
		
		return -1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N][M];
		isSelected = new boolean[N][M][2];

		for (int n = 0; n < N; n++) {
			input = in.readLine().split("");
			for (int m = 0; m < M; m++) {
				if (input[m].equals("1")) {
					arr[n][m] = 1;
				}
			}

		}
		
		System.out.println(bfs());

	}
	

}
