# [백준 - S5] 5972. 택배 배송

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다익스트라

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

- 다익스트라 기본 문제
- 우선순위 큐를 사용한다.
- 우선순위 큐에는 (비용, 현재 노드) 이런 형태로 저장한다.
- 출발점은 1번인니까 (0, 1)을 넣는다.
- while문을 돌면서 dummy값 확인
- 현재 노드와 연결된 점들을 보면서 다음 이동할 노드와 거기까지 가는데 비용을 계산한다.
- 비용이 원래 값보다 더 적을 경우 갱신하고 우선순위 큐에 넣는다.

```python
def dijk():
    pq = []
    heapq.heappush(pq, (0, 1)) # 비용, 위치
    distance[1] = 0

    while(pq):
        now_cost, now = heapq.heappop(pq)

        if now_cost > distance[now]:
            continue

        for node in graph[now]:
            next = node[1]
            next_cost = node[0] + now_cost

            if next_cost < distance[next]:
                distance[next] = next_cost
                heapq.heappush(pq, (next_cost, next))
```

## :black_nib: **Review**
다익스트라 재활 중...

## 📡**Link**

https://www.acmicpc.net/problem/5972