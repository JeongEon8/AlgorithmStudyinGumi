# [백준 - g5] 15686. 치킨 배달

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 브루트 포스
- 백트래킹

## ⏲️**Time Complexity**

## :round_pushpin: **Logic**

백 트래킹으로 치킨집 n개를 선택하는 조합을 모두 찾아 도시거리를 계산하여 도시거리의 최소값을 찾는다.

```cpp
static int getDist(Place h) {
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			int curDist = Math.abs(h.x - selectedChicken[i].x) + Math.abs(h.y - selectedChicken[i].y);
			if (minDist > curDist) {
				minDist = curDist;
			}
		}

		return minDist;
	}

	static void solve(int start, int depth) {
		if (depth == m) {
			int cityDist = 0;
			for (int i = 0; i < homeList.size(); i++) {
				cityDist += getDist(homeList.get(i));
			}
			if (ans > cityDist) {
				ans = cityDist;
			}
			return;
		}
		for (int i = start; i < chickenList.size(); i++) {
			selectedChicken[depth] = chickenList.get(i);
			solve(i + 1, depth + 1);
		}

	}

```

## :black_nib: **Review**

- 반례를 찾는데 시간을 한참 썼는데 long long타입이 필요한 문제였다.
- 문제 자체의 알고리즘 분류는 이분 탐색인데 시뮬레이션에 가깝게 구현하였다.

## 📡**Link**

- https://www.acmicpc.net/problem/15686
