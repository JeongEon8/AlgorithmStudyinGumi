# [백준 - G3] 2146. 다리 만들기

## ⏰ **time**

180분

## :pushpin: **Algorithm**

- bfs

## :round_pushpin: **Logic**

- 섬의 edge를 구해준 뒤 edge별로 가까운 다른 섬에 도착할 수 있게 bfs를 실시해 거리를 도출

```cpp
while (!q.empty() && done) {
		int nowx = q.front().second;
		int nowy = q.front().first;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int ny = nowy + dy[k];
			int nx = nowx + dx[k];
			if (ny < 0 || nx < 0 || ny == n || nx == n)continue;
			if(island[ny][nx] == true && box[ny][nx]==start)continue; // 처음 시작한 섬이면
			

			if (edgecopy[ny][nx] != 0 && edgecopy[ny][nx] != 0 && island[ny][nx]==true && edgecopy[ny][nx] != start) {
				if (answer > edgecopy[nowy][nowx] - start) { answer = edgecopy[nowy][nowx] - start;
				}
				done = false;
				break;
			}
			if (island[ny][nx])continue;
			if (edgecopy[ny][nx] == 0) {
				q.push({ ny,nx });
				edgecopy[ny][nx] = edgecopy[nowy][nowx] + 1;
			}

		}
	}
```

## :black_nib: **Review**

- bfs를 진행할 때 조건을 잘 정해 주어야한다...

## 📡**Link**

- https://www.acmicpc.net/problem/2146
