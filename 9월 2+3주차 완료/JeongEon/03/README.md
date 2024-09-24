# [백준 - 실버3] 2346. 풍선 터뜨리기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
데큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 앞뒤로 넣고 뺀다.
   ```cpp
	while (dq.empty() == false) {
		int num = dq.front().first;
		cout << dq.front().second << " ";
		dq.pop_front();

		if (dq.empty() == false) {
			if (num > 0) {
				for (int i = 0; i < num - 1; i++) {
					dq.push_back(dq.front());
					dq.pop_front();
				}		
			}
			else {
				for (int i = 0; i < abs(num); i++) {
					dq.push_front(dq.back());
					dq.pop_back();
				}
			}
		}
	}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/2346
