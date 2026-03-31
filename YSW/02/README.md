# [백준 - G3] 15804. 저거 못 타면 지각이야!! (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 시뮬레이션
- 덱

## ⏲️**Time Complexity**

$O(M)$

## :round_pushpin: **Logic**

시간 흐름에 따라 버스 정류장 배치를 시뮬레이션하는 문제였다. 현재 정류장에 있는 버스들을 큐(ArrayDeque)로 유지하면서, 각 버스 도착 시점마다 이미 출발한 버스를 제거해 상태를 갱신한다. 이후 시간 순서대로 들어오는 버스를 처리하면서 가능한 가장 앞 정류장부터 채워나가는 그리디 방식으로 처리했다.

```java
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int arriveTime = Integer.parseInt(st.nextToken());
			int stopTime = Integer.parseInt(st.nextToken());
			while (!queue.isEmpty()) {
				if (queue.peekFirst().departTime <= arriveTime) {
					queue.pollFirst();
				} else {
					break;
				}
			}

			if (queue.isEmpty()) {
				queue.addLast(new BusInfo(arriveTime, arriveTime + stopTime, 1));
			} else if (queue.peekLast().busStopIndex == n) {
				while (!queue.isEmpty()) {
					arriveTime = Math.max(arriveTime, queue.peekFirst().departTime);
					queue.pollFirst();
				}
				queue.addLast(new BusInfo(arriveTime, arriveTime + stopTime, 1));
			} else {
				arriveTime = Math.max(arriveTime, queue.peekLast().arriveTime);
				queue.addLast(new BusInfo(arriveTime, arriveTime + stopTime, queue.peekLast().busStopIndex + 1));
			}

			if (i == m - 1) {
				lastIdx = queue.peekLast().busStopIndex;
			}
		}

		System.out.println(lastIdx);
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/15804
