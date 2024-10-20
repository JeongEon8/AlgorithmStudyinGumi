# [백준 - S2] 16401. 과자 나눠주기

## ⏰ **time**

80분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

이분 탐색으로 막대과자의 길이를 정하고 줄 수 있는 인원수를 계산해서 최대길이를 구한다.

```java
Collections.sort(snackList, Collections.reverseOrder());
		int left = 1;
		int right = snackList.get(0);
		int mid = (left + right) / 2;
		while (left < right) {
			mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				int current = snackList.get(i);
				if (mid > current)
					break;
				cnt += current / mid;
			}
			if (cnt >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int current = snackList.get(i);
			if (left > current)
				break;
			cnt += current / left;
		}
```


## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/16401
