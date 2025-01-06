# [백준] 7569. 토마토    

## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
- 3차원 배열 값 입력받으면서, '익은 토마토 자리'는 queue에 추가한다. (출발점이 될 것이기 때문)
- 현재 것을 꺼낸다(poll). 이것에 반복문 + dx, dy, dz 붙여 다음 좌표로 이동한다.
- (다음 좌표 탐색하면서) 값이 0이면 (1)queue에 추가 / (2)다음 좌표값은 현재 좌표값의 +1... 즉, 앞으로 나아갈 때마다 +1이 된다.
  => 이 과정을 거치면 각 배열값이 삽입되어 있을 것이다. 이 중 가장 큰 값이 걸리는 최장 일수와 유사할 것이다.
  => 물론, 초기값(=출발점의 값)이 이미 1이었으므로 이 최댓값에서 -1 해줘야 한다.
```java
				if (nh >= 0 && nr >= 0 && nc >= 0 && nh < h && nr < n && nc < m) {
					if (map[nh][nr][nc] == 0) {
						queue.add(new Point(nh, nr, nc));
						map[nh][nr][nc] = map[height][row][col] + 1;
					}
				}
```
  
- 각 배열을 순회하며 최댓값을 찾는다. (result에 담음)
- 순회할 때, 0인 토마토가 발견되는 즉시 -1 리턴한다. (익지 않은 토마토가 존재한다는 것이므로)
```java
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0)
						return -1;
					result = Math.max(result, map[i][j][k]);

				}
			}
		}
```

- result-1 리턴.


## :black_nib: **Review**
- 3차원 배열 탐색 자체는 어렵지 않았다. dz만 추가하면 되니까...
- queue. bfs 얘네 아직도 서먹하다니 충격

## 📡**Link**
- https://www.acmicpc.net/problem/7569
