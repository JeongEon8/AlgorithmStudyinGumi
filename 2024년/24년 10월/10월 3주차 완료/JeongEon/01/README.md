# [백준 - 골드 4] 5052. 전화번호 목록
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
트라이

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 트라이
  여태까지 들어오지 않은 것은 새로운 배열에 넣는다.
  여태 들어왔던 것 중 끝을 finish에 표시한다.
   ```cpp
		for (int i = 1; i <= n; i++) {
			string input;
			cin >> input;

			if (flag == 1) {
				continue;
			}

			int before = 0;
			for (char c : input) {
				if (arr[before][c - '0'] == 0) {
					arr[before][c - '0'] = ++cnt;
				}

				before = arr[before][c - '0'];

				if (finish[before]) {
					flag = 1;
					break;
				}
			}
			if (before != cnt) {
				flag = 1;
			}

			finish[before] = 1;
		}
   ```

## :black_nib: **Review**
- 입력 다 안 받아서 틀리는 휴먼 에러 너무 힘들다.....

## 📡 Link
https://www.acmicpc.net/problem/5052
