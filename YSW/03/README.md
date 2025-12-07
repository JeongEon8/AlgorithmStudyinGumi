# [백준 - S3] 31872. 강의실 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

강의실의 좌표를 오름차순으로 정렬한 뒤, 인접한 강의실 사이의 거리 차이를 구한다.
강의실 사이의 거리차가 높은 방 순으로 K번 순간이동을 하고 나머지는 강의실 거리는 이동하는 거리 이므로 강의실 사이 거리 순으로 오름차순 정렬 후, 뒤에서 부터 K를 제외한 나머지 거리의 값들을 더해서 결과 값을 구한다.

```java
		for (int i = 0; i < N; i++) {
			room[i + 1] = Integer.parseInt(inputs[i]);
		}
		Arrays.sort(room);

		for (int i = 0; i < N; i++) {
			distance[i] = room[i + 1] - room[i];
		}
		Arrays.sort(distance);

		for (int i = 0; i < N - K; i++) {
			result += distance[i];
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/31872
