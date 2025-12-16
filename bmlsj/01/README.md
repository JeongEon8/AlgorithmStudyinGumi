# [백준 - G4] 10282. 해킹

## ⏰  **time**

40분

## ⏲️**Time Complexity**

$O(N \log N)$

## :round_pushpin: **Logic**

- 해킹당한 컴퓨터에서 출발하여 **최단 시간**에 감염되는 경로 탐색
- 그래프에서 **단일 출발점 최단 경로** 문제

다음 노드의 time을 더 한 값(`nextTime`)이 다음 `dist`값 보다 작으면 `dist`에 `nextTime`을 넣고
heap에 추가

```java
while (!heap.isEmpty()) {
    Node curr = heap.poll();
    int time = curr.time;
    int computer = curr.node;

    if (time > dist[computer])
     continue;

    for (Node next : graph[computer]) {
        int nextTime = time + next.time;
        if (nextTime < dist[next.node]) {
            dist[next.node] = nextTime;
            heap.add(new Node(next.node, nextTime));
        }
    }
}

int cnt = 0, maxTime = 0;
for (int i = 1; i <= n; i++) {
    if (dist[i] != Integer.MAX_VALUE) {
        cnt++;
        maxTime = Math.max(maxTime, dist[i]);
    }
}
```

## :black_nib: Review

의존성 방향 주의 => a가 b를 의존 (b -> a)

## 📡**Link**

- <https://www.acmicpc.net/problem/10282>
