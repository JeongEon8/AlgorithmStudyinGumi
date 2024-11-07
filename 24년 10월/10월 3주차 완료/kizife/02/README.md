# [백준] 1240. 노드 사이의 거리 
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
O(NM)

## :round_pushpin: **Logic**
```java
	static int[][] node; // 노드 간 연결 여부 저장하는 배열
	static int[][] distance; // 노드 간 거리 저장하는 배열
	static boolean[] visit; // 방문 여부
```

- bfs 실행
```java
		visit[start] = true; // 시작점 방문 표시
		queue.add(start); // 큐에 시작점 추가
		int[] arr = new int[n + 1]; // 시작점으로부터 각 노드까지의 거리를 저장할 배열
```

```java
				// 현재 노드와 연결된 노드이고 아직 방문하지 않은 경우
				if (node[now][i] == 1 && !visit[i]) {
					arr[i] = arr[now] + distance[now][i]; // 현재까지의 거리 + 연결된 거리 저장

					// 목표 노드에 도착했을 경우 거리 출력 후 종료
					if (i == end) {
						System.out.println(arr[end]);
						return;
					}

					queue.add(i); // 다음 노드를 큐에 추가
					visit[i] = true; // 방문 처리
				}
```

## :black_nib: **Review**
- 쉬운 문제였다는 것을 머리로는 아는데, 코드를 설계하기가 쉽지 않았다. (익숙하지 않아서?)

## 📡**Link**
- https://www.acmicpc.net/problem/1240 
