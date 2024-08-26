# [백준] 4903. 섬의 개수 
 
## ⏰  **time**
20분 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
344ms

## :round_pushpin: **Logic**
전형적인 dfs 문제이다.
```java
	static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		
		visited[x][y] = 1;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//nx, n는... 8방 이동한 후 새로운 좌표 
			
			if (nx<0 || ny<0 || nx>=h || ny>=w) continue; //범위에서 벗어날 시 그냥 넘어가기
			if (map[nx][ny] == 1 && visited[nx][ny] != 1) dfs(nx, ny); 
		}
		
	}
```


## :black_nib: **Review**
- dfs를 그나마? 익숙하게 만들어 준 문제... 

## 📡**Link**
- https://www.acmicpc.net/problem/4903 
