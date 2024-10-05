# [백준 - 골드3] 2206. 벽 부수고 이동하기
 
## ⏰  **time**
55분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 맵의 정보를 받을수 있는 2차원 배열 arr 을 생성하고, 벽부수기 횟수를 체크하면서 해당 지역을 방문 처리 하기 위해 3차원 배열 isSelected를 생성해준다.

2. bfs 탬색
   	- 상, 하, 좌, 우 4방향을 체크해준다
   	  	- 맵 밖으로 안나가는지, 벽 부수기 횟수에 따라 한번도 방문 안했는지,
	- 도착지점에 도달할경우 이동횟수를 리턴해준다.
	- 만약 bfs를 탐색을 다했는데 도착지점에 도달 못할경우 -1 리턴

3. bfs를 통해 나온 이동횟수 출력
   
   ```java
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
   ```

## :black_nib: **Review**
- 이 문제 말이 배고픈 원숭이랑 비슷했어요

## 📡 Link
https://www.acmicpc.net/problem/2206
