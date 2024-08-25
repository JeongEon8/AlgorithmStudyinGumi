# [백준 - 실버 5] 1676. 팩토리얼 0의 개수

## ⏰  **time**

1시간

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 뒤에 0이 나오는 경우는 2*5일 경우이다.
2. 따라서 소인수분해를 하여 5의 개수를 세면 된다.
```cpp
	for (int i = 5; i <= N; i *= 5) {
		result += N / i;
	}
```

## :black_nib: **Review**
- 뒤에서 하나씩 0을 세봤는데, 아니라서 풀이를 봤다.
- 이렇게 생각할수도 있구나...

## 📡 **URL**
https://www.acmicpc.net/problem/1676
