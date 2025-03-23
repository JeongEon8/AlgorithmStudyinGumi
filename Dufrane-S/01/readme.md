# [백준 - S2] 4963. 섬의 개수

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- bfs


## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
방문하지 않은 섬 방문시 bfs로 섬 전체에 방문 체크 & 섬 개수 ++
```java
for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==1&&done[i][j]==0) {
						answer++;
						done[i][j]=1;
						Queue<Dot>q = new ArrayDeque<>();// ArrayDeque
						Dot tmp = new Dot();
						tmp.y=i;
						tmp.x=j;
						q.add(tmp);
						while(!q.isEmpty()) {
							Dot now = q.poll();
							int nowx=now.x;
							int nowy=now.y;
							for(int k=0; k<8; k++) {
								int ny =nowy+dy[k];
								int nx =nowx+dx[k];
								if(ny<0||nx<0||ny==n||nx==m||map[ny][nx]==0||done[ny][nx]==1)continue;
								Dot next = new Dot();
								next.y=ny;
								next.x=nx;
								q.add(next);
								done[ny][nx]=1;
							}
						}
					}
				}
			}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/4963
