# [백준 - 실버 5] 1475. 방 번호

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 9나 6이면 더 적은 쪽을 올린다.
2. 다른 주면 수를 올린다.
```cpp
	for (int i = 0; i < N.length(); i++) {
		if (N[i] - '0' == 9 || N[i] - '0' == 6) {
			if (num[6] < num[9]) {
				num[6]++;
				maxi = max(maxi, num[6]);
			}
			else {
				num[9]++;
				maxi = max(maxi, num[9]);
			}
		}
		else {
			num[N[i] - '0']++;
			maxi = max(maxi, num[N[i] - '0']);
		}
	}
```

## :black_nib: **Review**
- 헤헤.. 멕스 처리 잘 못 했다.

## 📡 Link
https://www.acmicpc.net/problem/1475
