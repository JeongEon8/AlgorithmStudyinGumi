# [SWEA - D4] 1824. 혁진이의 프로그램 검증
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
구현(시뮬레이션)

## :round_pushpin: **Logic**
- 배열을 입력받을 때 `@`가 있는지 확인
  - 없다면 "NO"를 출력하면 됨
- 각 상태값에 따라 이동 방향을 변경하거나 메모리 값을 변경하면 됨
- `?`는 랜덤으로 방향이 결정된다고 했는데 이는 네 방향 모두 탐색을 해봐야 한다는 것과 같음
  - 따라서 BFS 탐색을 수행!
  - 이때, 방문 체크 배열을 4차원으로 선언해야 함 (`방향`, `메모리값`, `x`, `y`)
```java
static String bfs() {
	queue.offer(new Point(0, 0, 0));

	while (!queue.isEmpty()) {
		Point now = queue.poll();
		int x = now.x, y = now.y;
		char c = command[x][y];

		if (c == '@') {
			return "YES";
		} else {
			if (c == '?') { // 방향을 무작위로 (네 방향 모두)
				for (int i = 0; i < 4; i++) {
					addQueue(x + dx[i], y + dy[i], i);
				}
			} else {
				int d = -1;
				switch (c) {
				case '<': // 이동방향을 왼쪽으로 변경
					d = 1;
					break;
				case '>': // 이동방향을 오른쪽으로 변경
					d = 0;
					break;
				case '^': // 이동방향을 위로 변경
					d = 3;
					break;
				case 'v': // 이동방향을 아래로 변경
					d = 2;
					break;
				case '_': // 메모리에 0 저장? 오른쪽 : 왼쪽
					d = memory == 0 ? 0 : 1;
					break;
				case '|': // 메모리에 0 저장? 아래쪽 : 위쪽
					d = memory == 0 ? 2 : 3;
					break;
				case '.': // 아무것도 하지 않음
					d = now.d;
					break;
				case '+': // 메모리에 저장된 값 1 더하기
					if (++memory > 15)
						memory = 0;
					d = now.d;
					break;
				case '-': // 메모리에 저장된 값 1 빼기
					if (--memory < 0)
						memory = 15;
					d = now.d;
					break;
				default: // 0 ~ 9: memory 값 변경
					memory = command[now.x][now.y] - '0';
					d = now.d;
					break;
				}
				addQueue(x + dx[d], y + dy[d], d);
			}
		}
	}
	return "NO";
}
```

## :black_nib: **Review**
주어진 문자도 많고 조건도 많아서 복잡했다. 처음에는 단순 구현 코드로 작성했는데 네 방향 탐색을 해야 하는 경우가 있어서 BFS를 사용했다..
또한 3차원 배열을 이용해서 방문 체크를 했는데 답이 틀려서 찾아보니 4차원 방문 배열을 사용해야 한다고 했다.. 다차원 방문 배열을 사용하는건 어렵다..ㅜ

## 📡**Link**
- [[SWEA] 1824. 혁진이의 프로그램 검증](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV4yLUiKDUoDFAUx&categoryId=AV4yLUiKDUoDFAUx&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2)
