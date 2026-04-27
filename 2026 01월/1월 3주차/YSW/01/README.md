# [백준 - S1] 5014. 스타트링크 (Hard)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(F)$

## :round_pushpin: **Logic**

시작 층수 S에서 시작해서 목표층수 G에 가야한다.
위로 이동은 U 만큼 아래로 이동할때는 D 만큼만 이동할 수 있다.
S에서 시작해서 BFS로 U만큼 위로 이동할때 D만큼 아래로 이동할때를 Queue에 담고 count를 증가 시킨다.
목표 층수로 이동할 수 있으면 count를 출력하고, 갈 수 없다면 use the stairs 출력한다.

```java
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int currentFloor = queue.poll();

				if (currentFloor == G) {
					System.out.println(count);
					return;
				}

				int upFloor = currentFloor + U;
				int downFloor = currentFloor - D;
				if (upFloor > 0 && upFloor <= F && !visited[upFloor]) {
					queue.add(upFloor);
					visited[upFloor] = true;
				}
				if (downFloor > 0 && downFloor <= F && !visited[downFloor]) {
					queue.add(downFloor);
					visited[downFloor] = true;
				}
			}
			count++;
		}
		System.out.println("use the stairs");
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/5014
