# [백준 - S2] 1912. 연속합

## ⏰  **time**
2시간

## :pushpin: **Algorithm**
DP, 누적합

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 현재 값과 누적해서 더한값을 비교해서 더 큰 값을 합배열에 저장한다.
2. 현재 정답과 합배열 값을 비교해 더 큰 값을 정답에 저장한다.
```cpp
	int answer = -100001;
	for (int i = 0; i < n; ++i) {
		d[i] = max(arr[i], d[i - 1] + arr[i]);
		answer = max(answer, d[i]);
	}
```

## :black_nib: **Review**
- 누적합 같은데, 왜 DP라고 되어있지? 수상하다!!
- 알고리즘 하도 안 해도 감을 못 잡겠네.. 너무 오래 걸린다 한 문제 푸는데..

## 📡 Link
https://www.acmicpc.net/problem/1912
