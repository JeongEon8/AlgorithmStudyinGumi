# [백준 - S1] 33677. 푸앙이와 콩나무 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

BFS를 사용하여 콩나무의 길이를 N으로 만드는 최소 일수와 물의 양을 계산을 계산한다.
BFS는 가장 먼저 목표에 도달하는 경로가 최단 경로가 된다는 특성을 이용하여, 각 상태에서 물 1, 3, 5를 주는 규칙에 따라 가능한 모든 상태를 탐색합니다. 상태 변화는 물 1을 주면 높이가 1 증가하고, 물 3을 주면 높이가 3배가 되며, 물 5를 주면 높이가 제곱이 되는 방식으로 이루어집니다.
큐에 상태를 넣고, 각 상태에서 가능한 3가지 변환을 통해 새로운 상태를 탐색하며, 더 적은 일수와 물의 양을 가진 상태로 갱신합니다.
BFS는 가장 먼저 목표에 도달하는 경로가 최단 경로가 되므로, h == 0에 도달한 시점에서 최소 일수와 물의 양을 출력합니다. 이때의 값이 바로 문제의 답입니다.

```java
		while (!queue.isEmpty()) {
			State currentState = queue.poll();
			int h = currentState.hight;
			int d = currentState.day;
			int w = currentState.water;

			if (h == 0) {
				System.out.println(d + " " + w);
				return;
			}

			if (h - 1 >= 0) {
				int nh = h - 1;
				int nd = d + 1;
				int nw = w + 1;
				if (nd < bestDay[nh] || (nd == bestDay[nh] && nw < bestWater[nh])) {
					bestDay[nh] = nd;
					bestWater[nh] = nw;
					queue.add(new State(nd, nw, nh));
				}
			}

			if (h % 3 == 0) {
				int nh = h / 3;
				int nd = d + 1;
				int nw = w + 3;
				if (nd < bestDay[nh] || (nd == bestDay[nh] && nw < bestWater[nh])) {
					bestDay[nh] = nd;
					bestWater[nh] = nw;
					queue.add(new State(nd, nw, nh));
				}
			}

			int rt = (int) Math.sqrt(h);
			if (rt * rt == h) {
				int nh = rt;
				int nd = d + 1;
				int nw = w + 5;
				if (nd < bestDay[nh] || (nd == bestDay[nh] && nw < bestWater[nh])) {
					bestDay[nh] = nd;
					bestWater[nh] = nw;
					queue.add(new State(nd, nw, nh));
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/33677
