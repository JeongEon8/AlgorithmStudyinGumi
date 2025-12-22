# [백준 - 골드 4] 14499. 주사위 굴리기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. BFS로 이동 명령 진행행
2. 동,서,남,북으로 주사위 회전
3. 주사위 윗면 출력력
```java
private static void move() {
	while (!queue.isEmpty()) {
		int dir = queue.poll() - 1; // 입력값이 1-based이므로 -1

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		// 범위 체크
		if (!checkRange(nx, ny)) {
			continue; // 범위 벗어나면 무시
		}

		// 좌표 갱신
		x = nx;
		y = ny;

		// 주사위 회전
		rollDice(dir);

		// 지도와 주사위의 바닥면 값 처리
		if (map[x][y] == 0) {
			map[x][y] = dice[1]; // 주사위 바닥면이 복사됨
		} else {
			dice[1] = map[x][y]; // 지도의 값이 주사위 바닥면으로 복사
			map[x][y] = 0; // 지도는 0으로 변경
		}

		// 주사위 윗면 출력
		System.out.println(dice[0]);
	}
}
```

## :black_nib: **Review**
- 꼭꼭 숨어라..

## 📡 Link
https://www.acmicpc.net/problem/14499