# [백준 - 실버5] 2167. 2차원 배열의 합
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
1. 배열에 입력값을 저장한다.
2. 입력받는 좌표값을 기준으로 반복문을 돌아 누적합한다.
```cpp
	for (int k = 0; k < K; k++) {
		int x1, y1;
		int x2, y2;
		cin >> x1 >> y1 >> x2 >> y2;

		int sum = 0;
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				sum += arr[i][j];
			}
		}

		cout << sum << endl;
	}
```

## :black_nib: **Review**
- 2차원 누적

## 📡 Link
https://www.acmicpc.net/problem/2167
