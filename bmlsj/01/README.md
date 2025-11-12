
# [백준- S3] 1021. 회전하는 큐

## ⏰  **time**
30분

## :pushpin: **Algorithm**
Deque

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. `target` 수를 찾아서 위치인 `pos`를 계산한다.
2. `pos`가 큐의 크기의 절반보다 크면, 3번을 행하고 작으면 2번 연산을 행한다.
3. 2, 3번 연산을 할 때 마다 `ans + 1` 진행

```java
int idx = 0;
int ans = 0;
while (idx < M) {

	int target = findNum[idx];

	int pos = 0;
	for (int n : deque) {
		if (n == target)
			break;
  		pos++;
	}

	if (pos <= deque.size() / 2) {
		while (deque.peekFirst() != target) {
			deque.addLast(deque.pollFirst());
			ans++;
		}
	} else {
		while (deque.peekFirst() != target) {
			deque.addFirst(deque.pollLast());
			ans++;
		}
	}
			
	deque.pollFirst();
  idx++;
}
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1021

