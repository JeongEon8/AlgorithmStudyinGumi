# [백준 - 실버 4] 2776. 암기왕
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
맵

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 맵에 넣어두고, find를 이용해 end가 아니면 1 end면 0을 출력한다.
   ```cpp
		for (int i = 0; i < M; i++) {
			int input;
			cin >> input;

			if (memo1.find(input) != memo1.end()) {
				cout << 1 << "\n";
			}
			else {
				cout << 0 << "\n";
			}
		}
   ```

## :black_nib: **Review**
- 쉬웡 쉬웡

## 📡 Link
https://www.acmicpc.net/problem/2776
