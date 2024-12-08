# [백준 - G4] 1753. 최단경로

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 최단 거리, 다익스트라

## ⏲️**Time Complexity**

$O(v+e)$

## :round_pushpin: **Logic**

- 기본 다익스트라 문제인데 다익스트라를 까먹어서 풀어봤다.
- 이 부분이 핵심이다.
```python
hq = []
heapq.heappush(hq, (0, st))     # (비용, 위치)
distance[st] = 0

while hq:
    # 현재
    dist, now = heapq.heappop(hq)
    # 이미 비용이 더 작은 경우는 스킵
    if distance[now] < dist:
        continue

    # 현재 위치에서 갈 수 있는 노드들 탐색
    for node in graph[now]:
        cost = dist + node[1]
        next = node[0]

        if cost < distance[next]:
            distance[next] = cost
            heapq.heappush(hq, (cost, next))
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1753
