# [백준- G4] 1261. 알고스팟
 
## ⏰  **time**
80분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(NM)$
- N: 가로 길이, M: 세로 길이
## :round_pushpin: **Logic**
- (0,0)에서 주변탐색(상, 하, 좌, 우) 이동하려는 칸이 부순 숫자가 적을 경우 이동
  - 벽이 있을경우 현재 벽을 부순 숫자에 +1해서 해당 칸에 넣어준다.
  - 벽이 없을 경우 현재 벽을 부순 숫자을 넣어준다.
  - 0일경우 앞에 넣어주고 1일경우 뒤에 넣어준다.
- (N,M) 칸에 벽을 부순 숫자 출력
```java
   static void bfs() {
		Deque<Info>que = new ArrayDeque<Info>();
		Info info = new Info(0,0,0);
		count[0][0] = 0;
		que.add(info);
		
		count[0][0] = 0;
		while(!que.isEmpty()) {
			Info data = que.poll();
			for(int d = 0; d<4; d++) {
				int nx = data.x+dx[d];
				int ny = data.y+dy[d];
				if(nx<0 || nx>=M || ny<0 || ny>=N) {
					continue;
				}
				if(count[ny][nx]>data.br+arr[ny][nx]) {
					
					int newBr = data.br;
					if(arr[ny][nx]==1) {
						newBr+=1;
						count[ny][nx]=data.br+1;
						Info newData = new Info(nx,ny,newBr);
						que.addLast(newData);
					}else {
						count[ny][nx]=data.br;
						Info newData = new Info(nx,ny,newBr);
						que.addFirst(newData);
					}

				}
			}
		}
	}
```

## :black_nib: **Review**
0일때 앞에 넣고 1일때 뒤에 넣지 않으면 메모리 초과뜨더라구요(Deque 활용)

## 📡**Link**
- https://www.acmicpc.net/problem/1261
