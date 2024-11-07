# [백준] 14503. 로봇 청소기  
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
구현, 시뮬레이션 

## ⏲️**Time Complexity**
O(NM)

## :round_pushpin: **Logic**
1. 일단 문제에서 제시한 북동남서 순서대로 dx, dy 설정해줬다..
```java
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
```

2. clean 메서드에서 모든 걸 처리한다. 반복문을 만들어서 dir(방향)을 네 번 반시계 방향 회전하도록 했다.
3. 여기서 다음 좌표가 0이면 전진하여 clean을 다시 수행하는데, count를 ++해준다.
```java

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4; 

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (map[nx][ny] == 0) {
					count++;
					clean(nx, ny, dir);
					return;
				}
			}
		}
```

4. 바라보는 방향의 반대쪽, 즉 후진을 위한 bx, by를 설정하고 후방에 벽이 없으면 실행한다.
```java
		int d = (dir + 2) % 4; // 반대방향으로
		int bx = x + dx[d];
		int by = y + dy[d];

		if (bx >= 0 && by >= 0 && bx < n && by < m) {
			if (map[bx][by] != 1) {
				clean(bx, by, dir);
			}
		}
```


## :black_nib: **Review**
- 문제에서 제시한 '반시계 방향'이라는 것을 어떻게 구현할까 계속 헤맸다. 초기 입력시 dir값을 뒤집어 보기도 하고, dx와 dy 값의 순서를 바꾸기도 했다.
- 그런데 그냥 for문으로 4번 돌리면서 왼쪽으로 꺾어 주면 되는 거였다. ㅎ... 왜 굳이 i를 활용하는 것에 집착했는지?

## 📡**Link**
- https://www.acmicpc.net/problem/14503 
