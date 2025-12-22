# [백준 - 실버 2] 18111. 마인크래프트
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 블럭의 최대 높이는 256이다.
2. 최대 높이가 될 때까지 불럭을 쌓거나 빼가며 최소 시간을 찾는다.
```cpp
	for(int e= 0; e <= 256; e++) {
		int removeTime = 0;
		int putTime = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > e) {
					removeTime += arr[i][j] - e;
				}
				else if (arr[i][j] < e) {
					putTime += e - arr[i][j];
				}
			}
		}

		if (removeTime + b >= putTime) {
			int sumTime = removeTime * 2 + putTime;
			if (result >= sumTime) {
				result = sumTime;
				resultHeight = e;
			}
		}
	}
```

## :black_nib: **Review**
- 완탐 좋아

## 📡 Link
https://www.acmicpc.net/problem/18111
