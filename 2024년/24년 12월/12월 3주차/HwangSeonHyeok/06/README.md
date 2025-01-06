# [백준 - G4] 16166. 서울의 지하철

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 해시를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(KN^2)$

## :round_pushpin: **Logic**
호선에 역이 순환될수도 있어서 그냥 Set에 역 목록을 모두 담았다.  
근데 막상 만들고보니까 그냥 Set의 배열을 사용해도 됐을듯.
```java
	static class Line {
		Set<Integer> stationSet;

		public Line() {
			this.stationSet = new HashSet<Integer>();
		}

		public int getCnt() {
			return stationSet.size();
		}

		public void add(int station) {
			stationSet.add(station);
		}

		public boolean hasStation(int dest) {
			return stationSet.contains(dest);
		}
	}

```

이후 0번역이 있는 호선마다 bfs를 돌려서 최소 환승을 찾는다
```java
for (int i = 1; i <= n; i++) {
	if (lines[i].hasStation(0)) {
		Queue<Goofcode> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		q.add(new Goofcode(i, 0));
		visited[i] = true;
		while (!q.isEmpty()) {
			Goofcode cur = q.poll();
			if (lines[cur.line].hasStation(dest)) {
				ans = Math.min(ans, cur.step);
				break;
			}
			for (int station : lines[cur.line].stationSet) {
				for (int j = 1; j <= n; j++) {
					if (visited[j])
						continue;
					if (lines[j].hasStation(station)) {
						visited[j] = true;
						q.add(new Goofcode(j, cur.step + 1));

					}

				}

			}

		}

	}
}
```

## :black_nib: **Review**
N과 K값이 작아 이렇게 풀긴했는데 더 좋은 방법이 없었을까?

## 📡**Link**

https://www.acmicpc.net/problem/16166
