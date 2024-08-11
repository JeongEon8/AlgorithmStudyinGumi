# [백준 - G5] 2589. 보물섬
 
## ⏰  **time**
1시간 20분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O((R * C)^2)$

## :round_pushpin: **Logic**
1. 최단 거리를 구하는 문제라서 dfs를 사용

2. dfs를 할때 방문여부는 이동 시간으로 값을 입력

3. 처음 출발지는 시간이 0이므로 구한 시간에서 -1을 해준다.

```java
		while (!que.isEmpty()) {
			Place p = que.poll();

			int nx = p.x;
			int ny = p.y;

			// 상,하,좌,우 방향으로 육지체크
			for (int i = 0; i < 4; i++) {
				int cx = nx + dx[i];
				int cy = ny + dy[i];

				if (cx < 0 || cx >= C || cy < 0 || cy >= R) { // 지도 밖으로 나갔을때 예외처리
					continue;
				}

				if (map[cy][cx] == 0 && isSelect[cy][cx] == 0) { // 해당 지역이 육지이면서 방문을 안했을때
					que.offer(new Place(cx, cy)); // 큐에 좌표 넣기
					isSelect[cy][cx] = isSelect[ny][nx] + 1; // 이동할곳 방문 체크( 전 판에 있던 시간 +1)

				}

			}

		}
```

  

## :black_nib: **Review**
- 입력받은 String배열에서 R과C를 뽑는 과정에서 C를 뽑을 때 1번 인덱스를 뽑아야하는데 0번 인덱스를 뽑는 실수를 자주함

  
## 📡**Link**

- https://www.acmicpc.net/problem/2589


  
