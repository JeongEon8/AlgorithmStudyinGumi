# [백준 - 실버 5] 1652. 누울 자리를 찾아라
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(n^2)$

## :round_pushpin: **Logic**
1. 가로 세로를 탐색하며 . 이 2개 이상인지 확인한다.
2. 한 줄을 다 돌면 초기화 한다.
```cpp
for (int i = 0; i < N; i++) {
	for (int j = 0; j < N; j++) {
		if (arr[i][j] == 1) {
			cnt_row++;
		}
		else {
			cnt_row = 0;
		}

		if (arr[j][i] == 1) {
			cnt_col++;
		}
		else {
			cnt_col = 0;
		}

		if (cnt_row == 2) {
			row++;
		}

		if (cnt_col == 2) {
			col++;
		}
	}

	cnt_row = 0;
	cnt_col = 0;
}
```

## :black_nib: **Review**
- 와 행복한 실버

## 📡 Link
https://www.acmicpc.net/problem/1652
