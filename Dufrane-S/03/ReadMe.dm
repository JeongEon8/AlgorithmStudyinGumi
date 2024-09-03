# [백준 - S1] 1389. 케빈 베이컨의 6단계 법칙

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- bfs

## :round_pushpin: **Logic**

- 서로 친분있는지 확인하는 배열을 만들고 bfs를 하면서 최소 단계를 구해주었다.

```cpp
  //깊이 목표 i를 찾을 때까지 탐색...
while (!q.empty()) {
				int now = q.front().first;
				int depth = q.front().second;
				if (now == i) {
					sum += depth;
					break;
				}
				q.pop();
				for (auto k : box[now]) {
					if (done[k] == false) {
						q.push({ k,depth + 1 });
						done[k] = true;
					}
				}
			}
```

## :black_nib: **Review**

- 큰 수를 지정할 때 적당히 큰 값을 두지 말고 무조건 climits를 활용할 것...

## 📡**Link**

- https://www.acmicpc.net/problem/1389
