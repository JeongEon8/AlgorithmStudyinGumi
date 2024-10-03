# [백준 - G4] 14502. 연구소
 
## ⏰  **time**
90븐

## :pushpin: **Algorithm**
- dfs, bfs

## :round_pushpin: **Logic**
1. 연구소의 지도 배열에 바이러스와 벽의 정보를 넣을 때 바이러스 위치와 바이러스와 벽의 개수를 저장한다.

2. dfs를 통해 벽을 3개 생성해준다.

3. dfs에서 3개 생성할때마다 bfs를 통해 바이러스 퍼짐확인한다.
   	- 큐에 담을때마다 바이러스와 벽의 개수담는 변수 1개를 증가 시킨다.

4. bfs 탐색이 완료되면 전체 구역의 개수에서 바이러스와 벽의 개수 빼준다.

5.  4번의 결과랑 max랑 비교해서 더 큰 값을 넣어준다.

6.  dfs 탐색이 완료되면 max값을 출력한다.

```java
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
```

## :black_nib: **Review**
- 처음에는 dfs, bfs를 사용하면 시간초과 되는줄 알았지만 시간 복잡도 최대로 계산을 해보니 1073741824여서 2억이하라 가능해서 사용함

## 📡**Link**
- https://www.acmicpc.net/problem/14502
