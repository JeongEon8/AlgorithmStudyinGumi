# [백준 - G5] 13549. 숨바꼭질3

## ⏰  **time**
50분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. Deque를 사용해서 BFS 탐색한다.
2. 순간이동 (x * 2)은 0초 → offerFirst(): 앞에 넣기
3. 걷기 (x ± 1)는 1초 → offerLast(): 뒤에 넣기
4. 배열의 각 위치까지의 최소 시간을 저장한다.
```java
while (!dq.isEmpty()) {
	int x = dq.poll();

	// 순간이동 (우선순위 높음)
	if (x * 2 <= max && time[x * 2] == -1) {
		time[x * 2] = time[x];
		dq.offerFirst(x * 2); // 0초니까 앞에 넣기
	}

	// x - 1
	if (x - 1 >= 0 && time[x - 1] == -1) {
		time[x - 1] = time[x] + 1;
		dq.offerLast(x - 1); // 1초니까 뒤에 넣기
	}

	// x + 1
	if (x + 1 <= max && time[x + 1] == -1) {
		time[x + 1] = time[x] + 1;
		dq.offerLast(x + 1); // 1초니까 뒤에 넣기
	}
}
```

## :black_nib: **Review**
- 다음번에는 늦지 않고 제출하게여...

## 📡 Link
https://www.acmicpc.net/problem/13549
