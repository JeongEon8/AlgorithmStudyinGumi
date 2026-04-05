# [백준 - 실버 4] 2670. 연속부분최대곱

## ⏰ **time**
10분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. num[i] * num[i-1] 과 num [i]를 비교해서 더 큰 값을 저장한다.
```cpp
	for (int i = 1; i <= N; i++) {
		num[i] = max(num[i], num[i] * num[i - 1]);
		result = max(result, num[i]);
	}
```

## :black_nib: **Review**
- 요새 왜 이렇게 2000년대 kpop이 좋은지 모르겠어요
- [카라-Pretty Girl](https://www.youtube.com/watch?v=87OwZqwf3Wg) 

## 📡 Link
[https://www.acmicpc.net/problem/2670](https://www.acmicpc.net/problem/2670)
