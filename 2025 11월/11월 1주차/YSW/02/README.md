# [백준 - G4] 19538. 루머 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(V + E)$

## :round_pushpin: **Logic**

처음에 소문을 시작한 사람들을 큐에 넣고 해당 사람의 time 값을 0으로 설정합니다.
time의 의미는 time[i] = -1 이면 아직 소문을 믿지 않는 사람이고 time[i] != -1 이면 이미 소문을 믿는 사람이고
해당 time[i]의 값을 소문을 믿게 된 시간 입니다.
큐에 담긴 크기 만큼 사람들을 꺼내서, 그 사람의 이웃들을 확인하고, 다 확인하게 되면 currentTime가 증가하게 합니다.
아직 소문을 믿지 않는 사람 중 그 주변 사람들이 이미 소문을 믿고 있고 현재 시점보다 먼저(currentTime보다 작은 time) 소문을 들은 친구의 수를 셉니다.
그 수가 주변인의 전체 수의 절반 이상이면 해당 사람도 소문을 믿게 되서 큐에 추가 하고 time[hearer] = currentTime으로 믿게 된 시간을 기록합니다.
큐가 빌때 까지 반복합니다.

```java
		while (!queue.isEmpty()) {
			int size = queue.size();
			currentTime++;
			while (size-- > 0) {
				int currentRumor = queue.poll();

				for (int i = 0; i < graph[currentRumor].size(); i++) {
					int hearer = graph[currentRumor].get(i);
					if (times[hearer] == -1) {
						int cnt = 0;
						for (int j = 0; j < graph[hearer].size(); j++) {
							if (times[graph[hearer].get(j)] < currentTime && times[graph[hearer].get(j)] != -1) {
								cnt++;
							}
						}

						if (cnt * 2 >= graph[hearer].size()) {
							queue.add(hearer);
							times[hearer] = currentTime;
						}
					}
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/19538
