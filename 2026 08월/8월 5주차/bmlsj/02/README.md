# [PGS - LV2] 02\_배달

## ⏰**time**

30분

## :pushpin: **Algorithm**

최단거리(다익스트라)

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 기존 거리보다 새로운 경로(`dist[now] + next.cost`)가 더 빠르다면, 더 작은 값으로 갱신
2. 최단 거리가 줄어들었으므로 pq에 next값을 등록한다.
3. K보다 작은 마을 개수를 answer에 저장

```java
PriorityQueue<Node> pq = new PriorityQueue<>();
pq.offer(new Node(1, 0));

while(!pq.isEmpty()) {
    Node curr = pq.poll();

    int now = curr.to;
    int time = curr.cost;

    if (time > dist[now]) continue;

    for(Node next: graph[now]) {
        if (dist[next.to] > dist[now] + next.cost) {
            dist[next.to] = dist[now] + next.cost;
            pq.offer(new Node(next.to, dist[next.to]));
        }
    }
}

for(int i = 1; i <= N; i++) {
    if (dist[i] <= K) answer++;
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12978>
