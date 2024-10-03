# [백준 - 골드5] 9205. 맥주 마시면서 걸어가기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 각각의 입력을 받는다.
2. 방문 배열을 만든다.
3. q에 집 위치를 넣는다.
4. q의 y, x와 편의점의 y, x의 차합이 1000이하일 때 방문배열을 true로 바꾸고, q에 push한다.
5. q의 y, x,의 값이 festival의 y, x의 차합이 1000이하 일때 happy출력
   아닐 때, sad 출력
```cpp
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();

			if (abs(festival.front().first - y) + abs(festival.front().second - x) <= 1000) {
				result = true;
				cout << "happy\n";
				break;
			}

			for (int i = 0; i < n; i++) {
				if (visited[i] == true) {
					continue;
				}

				if (abs(convenienceStore[i].first - y) + abs(convenienceStore[i].second - x) <= 1000) {
					visited[i] = true;
					q.push({ convenienceStore[i].first, convenienceStore[i].second });
				}
			}
		}
```

## :black_nib: **Review**
- 엇.. 생각보다 안풀렸다. 감을 좀 잡아야겠다.

## 📡**Link**
- https://www.acmicpc.net/problem/9205
