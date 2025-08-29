
# [백준- G5] 9205. 맥주 마시면서 걸어가기

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

편의점의 위치를 모두 `stores`에 넣고, `start`에서 시작해 `dest`와의 거리가 1000이하면 `happy`를 아니면 `sad`를 출력한다.

1. `start`를 큐에 넣고, 방문했다면 `visited` 에 해당 좌표를 넣는다.
2. 현재 좌표에서 방문하지 않은 모든 좌표를 탐색해, 거리가 1000이하인 곳으로 이동한다.
3. 만약 현재 위치에서 목적지인 `dest`와의 거리가 1000이하면 도착할 수 있다.

```java
static void move(Node start, Node dest, List<Node> stores) {

	Queue<Node> queue = new ArrayDeque<>();
	queue.offer(start);
	visited.add(start.x + "," + start.y);

	while (!queue.isEmpty()) {
		Node curr = queue.poll();
		int dis = Math.abs(curr.x - dest.x) + Math.abs(curr.y - dest.y);

		if (dis <= 1000) {
			System.out.println("happy");
			return;
		}

		for (Node store : stores) {
			dis = Math.abs(curr.x - store.x) + Math.abs(curr.y - store.y);
			if (!visited.contains(store.x + "," + store.y) && dis <= 1000) {
				visited.add(store.x + "," + store.y);
				queue.offer(store);
			}
		}

	}

	System.out.println("sad");
}
```


## :black_nib: **Review**
처음에는 모든 좌표를 `queue`에 넣고, move함수에서는 queue에서 뽑아낸 위치에서 1000이하인 곳으로만 이동했는데
그렇게 하면, 현재 위치에서 이동 가능한 모든 노드를 탐색할 수 없다. 단순히 큐에서 뽑은 노드를 마지막 위치와만 비교하게 된다.


## 📡**Link**
- https://www.acmicpc.net/problem/9205

