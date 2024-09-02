# [백준 - G5] 15686. 치킨 배달
 
## ⏰  **time**
1시간 20분

## :pushpin: **Algorithm**
완전탐색 (조합)

## :round_pushpin: **Logic**
- 치킨집의 총 개수에서 M개를 선택하는 것 & 순서 상관 없음 ⇒ 조합을 사용하면 됨
- M개의 치킨집을 선택하면 도시의 치킨 거리 최솟값 구하기
- 그렇지 않으면 치킨집을 선택하기
```java
private static void dfs(int depth, int start) {
	if (depth == M) { // M개의 치킨집을 선택한 경우
		// 도시의 치킨 거리의 최솟값 구하기
		minDist = Math.min(minDist, getDistance());
		return;
	}

	for (int i = start; i < chickenList.size(); i++) {
		Point p = chickenList.get(i);
		if (!check[p.x][p.y]) { // 현재 치킨집을 선택하지 않은 경우
			check[p.x][p.y] = true; // 치킨집 선택하기
			dfs(depth + 1, i + 1); // 다음으로 취소할 치킨집 선택하기
			check[p.x][p.y] = false; // 치킨집 선택 취소하기
		}
	}
}
```

## :black_nib: **Review**
선택해야 하는 치킨집의 개수가 최대 13개여서 완탐으로 풀어야 되겠다고 생각했다. 
그리고 총 치킨집의 개수에서 순서 상관없이 m개를 뽑는 것이므로, 조합을 만드는 방식으로 진행했다.
조합을 구현하는 부분에서 시작 인덱스를 주는 것을 까먹어서 시간 초과가 나긴 했지만 그래도 풀이를 참고하지 않고 푼 것에 만족한다.

## 📡**Link**
- [백준 15686_치킨 배달](https://www.acmicpc.net/problem/15686)
