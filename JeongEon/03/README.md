# [백준 - 실버 5] 7568. 덩치

## ⏰  **time**

20분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. 나보다 키도 크고 몸무게도 많이 나가는 사람을 만날 때만 cnt++을 해준다.
```cpp
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (i == j) {
				continue;
			}

			if (people[i][0] < people[j][0]) {
				if (people[i][1] < people[j][1]) {
					cnt[i]++;
				}
			}
		}
		cout << cnt[i] + 1 << " ";
	}
```

## :black_nib: **Review**
- 크거나 같은 경우로 계속 돌리다가 왜 안되지 했더니 같은 경우는 안되는 거였다.
- 문제를 제대로 보자...

## 📡 **URL**
https://www.acmicpc.net/problem/7568
