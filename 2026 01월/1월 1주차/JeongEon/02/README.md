# [백준 - 실버 3] 1021.회전하는 큐

## ⏰**time**
32분

## :pushpin: **Algorithm**
데큐(deque)

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 현재 데큐 속 찾으려는 숫자의 위치를 찾는다.
2. 찾으려는 수가 back에 가까우면 오른쪽으로 이동
3. 찾으려는 수가 front에 가까우면 왼쪽으로 이동

```cpp
		for (int i = 0; i < dq.size(); i++) {
			if (dq[i] == findNum) {
				idx = i;
				break;
			}
		}

		// 찾으려는 수가 뒷번호에 가까우면?
		if (idx > dq.size()/2) {
			while (dq.front() != findNum) {
				right_function();
			}
		}
		// 찾으려는 수가 앞번호에 가까우면?
		else if (idx <= dq.size() / 2) {
			while (dq.front() != findNum) {
				left_function();
			}
		}
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/1021](https://www.acmicpc.net/problem/1021)
