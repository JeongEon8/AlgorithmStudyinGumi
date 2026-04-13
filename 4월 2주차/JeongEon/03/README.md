# [백준 - 골드 5] 2565.전깃줄

## ⏰ **time**
49분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. A 기준으로 오름차순 정렬한다.
2. LIS(가장 긴 증가하는 수열) 알고리즘을 적용한다.
  -  8, 2, 9, 1, 4, 6, 7, 10 에서 가장 긴 수열은 2, 4, 6, 7, 10이다.
  -  이처럼 A가 오름차순일 때 전깃줄을 겹치지 않게 하려면, B도 함께 오름차순이어야한다.
```cpp
	for (int i = 0; i < N; i++) {
		int tmp = 0;
		for (int j = 0; j < i; j++) {
			if (wire[i].second > wire[j].second) {
				tmp = max(tmp, dp[j]);
			}
		}
		dp[i] = tmp + 1;
	}
```

## :black_nib: **Review**
- 아 왜 안 풀리지 하면서 머리 싸매는건.. 딱 30분까지가 좋은 거 같다..

## 📡 Link
[https://www.acmicpc.net/problem/2565](https://www.acmicpc.net/problem/2565)
