# [백준 - 실버 2] 1535.안녕

## ⏰ **time**
20분

## :pushpin: **Algorithm**
완전탐색

## ⏲️ **Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 순서대로 인사를 할지 말지는 정한다.
2. 만약 인사를 했다면 `life`와 `joy`를 더하며 함수를 재귀 호출한다.
3. `life`가 100을 넘기면 `return`을 통해 돌아오고, 그렇지 않다면 `joy`가 `max_joy`보다 큰지 확인한다.

```cpp
void hello(int n, int life, int joy) {
	if (life >= 100) {
		return;
	}

	if (joy > max_joy) {
		max_joy = joy;
	}

	for (int i = n; i < N; i++) {
		hello(++n, life + L[i], joy + J[i]);
	}
}
```

## :black_nib: **Review**
- 오늘은 메가커피 복숭아 아이스티를 마시면서 알고리즘을 풀어요.
- 복숭아 아이스티가 3,000원이더군요! 세상에!
- 내 마음속 아이스티 가격은 2,000원이었는데, 어느새 이렇게 가격이 올랐어요...

## 📡 Link
[https://www.acmicpc.net/problem/1535](https://www.acmicpc.net/problem/1535)
