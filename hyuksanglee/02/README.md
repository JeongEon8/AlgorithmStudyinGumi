# [백준 - G4] 6593. 상범 빌딩

## ⏰  **time**
70분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. bfs를 사용해서 주변탐색(상,하,좌,우,위층,아래층) 후 금이 가져 있지 않은곳을 탐색하면 끝
```java
        static int bfs() {
		
		// 큐 생
		Queue<Info> que = new ArrayDeque<Info>();
		// 시작점 넣기
		Info inputInfo = new Info(doorway[0][0],doorway[0][1],doorway[0][2],0);
		// 현재 위치 방문처리 하기
		isCheck[doorway[0][0]][doorway[0][1]][doorway[0][2]] = true;
		// 큐에 시작점 담기
		que.add(inputInfo);
		
		// 큐에 값이 비어있을때까지 반복
		while(!que.isEmpty()) {
			// 큐에서 현재 좌표 꺼내기
			Info infoC = que.poll();
			
			// 출구에 도착했을 때
			if(infoC.l == doorway[1][0] && infoC.r == doorway[1][1] && infoC.c == doorway[1][2]) {
				return infoC.count;
			}
			
			// 주변 탐색
			 
			for( int d =0; d<6; d++) { 	
				int nl = infoC.l + dl[d]; 	// 탐색하려는 층수
				// 상, 하, 좌, 우
				int nr = infoC.r + dr[d]; 	 
				int nc = infoC.c + dc[d];
				
				// 탐색하려는 좌표가 건물 밖에 나가면 건너뛰기
				if(nl <0 || nr <0 || nc < 0 || nl>=L || nc>= C || nr >= R) {
					continue;
				}
				if( isCheck[nl][nr][nc]== false && !building[nl][nr][nc].equals("#")) { // 한번도 방문하지 않았고 금이 가지 않은 곳
					Info newInfo = new Info(nl, nr, nc, infoC.count+1);
					que.add(newInfo);
					// 현재 위치 방문처리 하기
					isCheck[nl][nr][nc] = true;
				}
				
				
			}
		}
		
		return 0;
	}
```


## :black_nib: **Review**
- 오랜만에 bfs푸니깐 방문처리도 안해주고 푸는법 까먹었어요

## 📡**Link**
- https://www.acmicpc.net/problem/6593
