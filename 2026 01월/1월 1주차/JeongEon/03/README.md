# [백준 - 실버 5] 2161.카드1

## ⏰**time**
5분

## :pushpin: **Algorithm**
큐(queue)

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. `front()` 를 출력 후 `pop()`
2. `front()` 를 변수에 저장 후 `pop()`
3. 변수에 저정된 값을 큐에 `push()`

```cpp
	while (!q.empty()) {
		throwTop();
		if (!q.empty()) {
			topCardMove();
		}
	}

  // 카드버리기
  void throwTop() {
  	cout << q.front() << " ";
  	q.pop();
  }
  
  // 윗장을 아래로 옮긴다.
  void topCardMove() {
  	int tmp = q.front();
  	q.pop();
  	q.push(tmp);
  }
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/2161](https://www.acmicpc.net/problem/2161)
