# [백준 - G4] 16398. 행성 연결

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그래프 이론
- 최소 스패닝 트리

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

최소 스패닝 트리를 만들어서 연결한 Edge의 코스트를 모두 더해주면된다.

```java
	static int[] parents;
	static int findParents(int idx) {
		if(parents[idx]==idx) {
			return idx;
		}
		return parents[idx] = findParents(parents[idx]);
	}
	static boolean setGroup(int a, int b) {
		int aRoot = findParents(parents[a]);
		int bRoot = findParents(parents[b]);
		if(aRoot==bRoot) {
			return false;
		}else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	long ans = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(setGroup(e.a,e.b)) {
				ans+=e.cost;
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16398
