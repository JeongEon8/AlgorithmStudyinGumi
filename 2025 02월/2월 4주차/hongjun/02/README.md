# [백준 - G4] 10282. 해킹
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
- 다익스트라

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. b에서 a로 갈 때 비용이 s라고 생각한다.
2. 비용이 작은 것 부터 우선순위 큐인 heapq를 사용한다.
3. (비용, 노드) 형식으로 힙큐에 저장한다.
4. 다음 노드의 비용과 이전 노드에서 온 비용 + 다음 비용을 비교해서 갱신한다.
5. INF가 아닌 것 중에 최대값을 출력한다.
```python
def dijk(start, graph):
    # 최단 시간
    distance = [INF] * (n+1)

    pq = []
    distance[c] = 0
    heapq.heappush(pq, (0, start))

    while pq:
        cost, now = heapq.heappop(pq)

        if cost < distance[now]:
            continue

        for next_cost, next in graph[now]:

            if distance[next] > cost + next_cost:
                distance[next] = cost + next_cost
                heapq.heappush(pq, (cost + next_cost, next))

    res_cnt, res_time = 0, 0
    for time in distance:
        if time < INF:
            res_cnt += 1
            if time > res_time:
                res_time = time

    return res_cnt, res_time

```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/10282
