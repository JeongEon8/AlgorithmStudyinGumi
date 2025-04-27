# [백준 - 실버 4] 2217. 로프

## ⏰  **time**
30

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 로프를 병렬로 연결했을 때, 각각의 로프에 모두 고르게 w/k의 중량이 걸린다.
2. 모두 고르게 w/k의 중량이 걸릴 때, 최대로 들 수 있는 중량은 k개의 로프 중 버틸 수 있는 중량이 가장 작은 로프의 버틸 수 있는 중량 * k개 이다.
```cpp
	sort(input, input + n);

	for (int i = 0; i < n; i++) {
		answer = max(answer, (n - i) * input[i]);
	}

	cout << answer;
```

## :black_nib: **Review**
- 후히히 생각보다 많이 쉬이ㅝㅆ다

## 📡 Link
https://www.acmicpc.net/problem/2217
