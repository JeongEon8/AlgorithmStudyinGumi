# [백준 - 실버 3] 1966. 프린터 큐

## ⏰  **time**

20분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. 우선순위 큐를 이용해 프린트의 우선순위를 고려한다.
```cpp
		while (!q.empty()) {
			int index = q.front().first;
			int value = q.front().second;
			q.pop();
			if (pq.top() == value) {
				pq.pop();
				++count;
				if (index == m) {
					cout << count << endl;
					break;
				}
			}
			else q.push({ index,value });
		}
```

## :black_nib: **Review**
- 

## 📡 **URL**
https://www.acmicpc.net/problem/1966
