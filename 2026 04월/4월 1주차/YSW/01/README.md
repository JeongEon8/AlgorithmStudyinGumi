# [백준 - G5] 18231. 파괴된 도시 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 브루트포스 알고리즘
- 그래프 탐색

## ⏲️**Time Complexity**

$O(N + M)$

## :round_pushpin: **Logic**

파괴된 도시 목록이 주어졌을 때, 어떤 도시에 폭탄이 떨어졌는지를 역으로 추론하는 문제였다.
폭탄이 떨어진 도시라면, 그 도시의 모든 인접 도시도 반드시 파괴되어 있어야 하므로, 모든 파괴된 도심 중 주변에 멀쩡한 도시가 없는 도시를 전부 폭탄 투하 지점으로 가정하고, 그 결과가 원본 지도와 같은지 대조한다.

```java
		for (int i = 1; i <= N; i++) {
			if (!isDestroyed[i]) {
				continue;
			}

			boolean canDrop = true;
			for (int neighbor : towns[i]) {
				if (!isDestroyed[neighbor]) {
					canDrop = false;
					break;
				}
			}

			if (canDrop) {
				bombTargets.add(i);
			}
		}

		for (int target : bombTargets) {
			expected[target] = true;
			for (int neighbor : towns[target]) {
				expected[neighbor] = true;
			}
		}

		boolean possible = true;
		for (int i = 1; i <= N; i++) {
			if (expected[i] != isDestroyed[i]) {
				possible = false;
				break;
			}
		}

		if (possible && !bombTargets.isEmpty()) {
			System.out.println(bombTargets.size());
			for (int target : bombTargets) {
				sb.append(target).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/18231
