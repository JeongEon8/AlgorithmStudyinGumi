# [백준 - 실버 2] 17086. 아기 상어2
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 모든 좌표에서 bfs를 통해 안전거리 구해주기
```java
while(!q.isEmpty()&&result==0) {
			Dot now = q.poll();
			int nowy=now.y;
			int nowx=now.x;
			for(int i=0; i<8; i++) {
				int ny=nowy+dy[i];
				int nx=nowx+dx[i];
				if(ny<0||nx<0||ny==N||nx==M||tmpmap[ny][nx]<0)continue;
				if(tmpmap[ny][nx]==1) {
				    if(result>tmpmap[nowy][nowx]-1)result=tmpmap[nowy][nowx]-1;
				    break;
				} else {
					tmpmap[ny][nx]=tmpmap[nowy][nowx]-1;
					d= new Dot();
					d.y=ny;
					d.x=nx;
					q.add(d);
				}
			}
		}
```


## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/17086
