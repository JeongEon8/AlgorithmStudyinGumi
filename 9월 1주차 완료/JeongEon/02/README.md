# [백준 - 실버 3] 2579. 계단 오르기
 
## ⏰  **time**
이틀

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N -3)$

## :round_pushpin: **Logic**
1. 1칸 건너뛰고 오를지, 1칸 건너뛰었고 연속해서 오를지 판단한다.
```cpp
	result[1] = stair[1];
	result[2] = stair[2] + stair[1];
	result[3] = max(stair[1] + stair[3], stair[2] + stair[3]);
	for (int i = 4; i <= N; i++) {
		result[i] = max(result[i - 3] + stair[i - 1] + stair[i], result[i - 2] + stair[i]);
	}
```

## :black_nib: **Review**
- DP너무 어렵다.
## 📡 Link
https://www.acmicpc.net/problem/2579
