# [백준] 1189. 컴백홈   
 
## ⏰  **time**
15분 

## :pushpin: **Algorithm**
그래프 탐색, dfs, 백트래킹 

## ⏲️**Time Complexity**
176 ms

## :round_pushpin: **Logic**
- dfs를 활용한 아주 간단한 문제였다.
- 출발점, depth를 삽입하여 dfs 돌림

- 도착점에 이르렀을 때 depth가 k라면 count를 늘리도록 한다.
- ```java
		if (x == 0 && y == c - 1) {
			if (depth == k) {
				
				count++;
			}
			return;
		}
  ```

- 범위 내에 있고, 방문 아직 안 했고, T가 아닐 경우 depth를 1 늘리며 dfs 실행
- ```java
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visit[nx][ny] && map[nx][ny] != 'T') {

				dfs(nx, ny, depth + 1);

			}

		}
  ```

## :black_nib: **Review**
-  시험에 이런 문제만 나왔으면 좋겠다. 

## 📡**Link**
- https://www.acmicpc.net/problem/1189 
