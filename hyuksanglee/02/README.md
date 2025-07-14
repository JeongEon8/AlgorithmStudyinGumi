# [백준 - G4] 3055. 탈출

## ⏰ **time**

60분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 물을 주변 한칸씩 늘려준다
   - for문을 사용해서 방금 채워진 물부분을 찾아서 주변 땅 부분을 물로 채우준다
2. 현재 고슴도치 위치에서 주변에 땅이 곳을 이동한다.
3. 이동한곳이 비버굴이면 지금까지 시간 출력 해준다.
   - bfs 탐색을 다했는데 비버굴을 못 찾으면 KAKTUS 출력 
```java
	// 분당 물 채워주는 함수
	private static void changeW(int t) {
		for(int r = 0; r< R; r++) {
			for(int c = 0; c<C; c++) {
				if(isCheck[r][c] == t) {
					for(int d = 0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c + dc[d];
						if(nr<0 || nc <0 || nr>= R || nc >= C) {
							continue;
						}
						
						if(isCheck[nr][nc] <= 0 && map[nr][nc] == '.') {
							isCheck[nr][nc] = t+1;
							map[nr][nc] ='*';
						}
					}
				}
			}
		}
		time++;
		
	}

	// bfs 함수
	private static void dfs(int i, int j, int t) {
		Info info = new Info(i,j,t);
		Queue<Info> que = new ArrayDeque();
		
		que.add(info);
		
		while(!que.isEmpty()) {
			Info data = que.poll();
			int cr = data.r;
			int cc = data.c;
			int ct = data.t;
			
			if(ct >= time) {
				changeW(ct);
			}
			
			for(int d=0; d<4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				
				
				if(nr <0 || nc <0 || nr>=R || nc>=C) {
					continue;
				}
				
				if(map[nr][nc]=='D') {
					System.out.println(ct);
					result = false;
					return;
				}
				
				if(map[nr][nc] == '.' && isCheck[nr][nc]==0) {
					isCheck[nr][nc]=-1;
					Info newInfo = new Info(nr, nc, ct+1);
					que.add(newInfo);
				}
			}
			
			
		}
		
	}
```

## :black_nib: **Review**  
bfs도 푸는데 범위 생각 안하고 풀어서 처음에 오류 뜨더라구요
## 📡**Link**
https://www.acmicpc.net/problem/3055
