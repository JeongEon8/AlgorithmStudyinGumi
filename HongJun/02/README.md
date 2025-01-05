# [백준 - G4] 2665. 미로만들기

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다익스트라

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
- 벽이 아닌 곳을 갈 때는 가중치가 0, 벽이 있는 곳을 갈 때는 가중치가 1이다.
- 다익스트라를 이용해서 각 좌표까지 갈 때 최소 비용을 구한다.

```python
def dijk():
    pq = []
    heapq.heappush(pq, (0, 0, 0)) # 비용, y좌표, x좌표
    best[0][0] = 0

    while pq:
        price, nowY, nowX = heapq.heappop(pq)

        # dummy 제거
        if price > best[nowY][nowX]:
            continue

        for i in range(4):
            nextY = nowY + dy[i]
            nextX = nowX + dx[i]

            # 좌표가 범위 안에 있을 때
            if 0 <= nextY < n and 0 <= nextX < n:
                tmp = room[nextY][nextX]
                # 다음 이동할 좌표가 벽일 때
                if room[nextY][nextX] == 0:
                    if best[nextY][nextX] > price + 1:
                        best[nextY][nextX] = price + 1
                        heapq.heappush(pq, (price + 1, nextY, nextX))
                # 그냥 갈 수 있으면 비용이 0
                else:
                    if best[nextY][nextX] > price:
                        best[nextY][nextX] = price
                        heapq.heappush(pq, (price, nextY, nextX))
```

## :black_nib: **Review**
어렵네 이거..

## 📡**Link**

https://www.acmicpc.net/problem/2665