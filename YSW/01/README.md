# [백준 - G4] 16469. 소년 점프 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(R*C)$

## :round_pushpin: **Logic**

각 악당마다 BFS를 수행하여, 해당 악당의 시작 위치로부터 미로의 모든 칸까지의 최단 거리를 구한다.
이후 미로의 각 위치를 확인하면서 세 악당 모두 도달할 수 있는 칸을 찾는다.
그 칸에서 세 악당이 동시에 만날 수 있으려면, 세 악당이 그 칸에 도착하는 시간 중 가장 늦은 시간(최댓값) 이 실제 만나는 시간이 된다.
모든 칸에 대해 이 만나는 시간을 구한 뒤, 그 중 최소값을 찾고,
이 최소 만남 시간과 동일한 칸의 개수를 세어 출력한다.
(더 작은 최소 시간이 발견되면 카운트를 1로 초기화하고, 같은 시간이면 카운트를 1씩 증가시킨다.)

```java
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				Person currentPerson = queue.poll();
				int currentIndex = currentPerson.index;
				int currentRow = currentPerson.row;
				int currentCol = currentPerson.col;
				int currentCount = currentPerson.count;

				for (int i = 0; i < directions.length; i++) {
					int newRow = currentRow + directions[i][0];
					int newCol = currentCol + directions[i][1];

					if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C && maze[newRow][newCol] == 0
							&& !visited[currentIndex][newRow][newCol]) {
						queue.add(new Person(currentIndex, newRow, newCol, currentCount + 1));
						distance[currentIndex][newRow][newCol] = currentCount + 1;
						visited[currentIndex][newRow][newCol] = true;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[0][i][j] && visited[1][i][j] && visited[2][i][j]) {
					int meetingTime = Math.max(distance[0][i][j], Math.max(distance[1][i][j], distance[2][i][j]));
					if (minMeetingTime == -1) {
						minMeetingTime = meetingTime;
						meetCount = 1;
					} else if (minMeetingTime > meetingTime) {
						minMeetingTime = meetingTime;
						meetCount = 1;
					} else if (minMeetingTime == meetingTime) {
						meetCount++;
					}
				}
			}
		}
```

## :black_nib: **Review**

“OK 계획대로 되고 있어”

## 📡**Link**

https://www.acmicpc.net/problem/16469
