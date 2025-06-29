# [백준 - 골드 5] 5430. AC
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
테스트케이스:T, 명령어 처리: O(L)
$O(T × (L + N))$

## :round_pushpin: **Logic**
1. Deque<Integer> deque를 정의하고, split한 정수값들을 넣음
2. R 혹은 D 명령어에 따라 뒤집기와 삭제를 진행
3. 최종값을 StringBuilder로 넣음 
```java
for (String cmd : p) {
	if (cmd.equals("R")) {
		isReversed = !isReversed;
	} else if (cmd.equals("D")) {
		if (deque.isEmpty()) {
			isError = true;
			break;
		}
		if (isReversed) {
			deque.pollLast();
		} else {
			deque.pollFirst();
		}
	}
}
```

## :black_nib: **Review**
- ArrayList로 구현하려다가 for문으로 순서를 바꿔가며 하는게 비효율적이라 deque를 써서 삭제하는 방향을 확인하고 양방향에서 제거하는 걸로 수정했습니다.

## 📡 Link
https://www.acmicpc.net/problem/5430
