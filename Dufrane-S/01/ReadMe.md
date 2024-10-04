# [백준 - 실버1] 1325. 효율적인 해킹
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2^)$

## :round_pushpin: **Logic**
1. bfs로 연결확인 후 구하기
   ```cpp
		while (!q.empty()) {
			int now = q.front();
			q.pop();
			for (auto k : box[now]) {
				if (done[k] == false) {
					done[k] = true;
					q.push({ k });
					coms.push_back(k);
				}
			}
		}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/1325
