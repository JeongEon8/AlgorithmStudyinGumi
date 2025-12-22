# [백준 - G4] 4485. 녹색 옷 입은 애가 젤다지?

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다익스트라

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

- 2차원 배열에서 다익스트라를 사용하는 문제
- 4방향으로 이동하면서 각 좌표까지 갈 때 드는 최소비용으로 갱신해준다.
- 도착 지점까지 가면 모든 좌표에 도달했을 때 최소 비용을 구할 수 있다. 

```python
def move_min_cost(a, b, problem):
    q = []
    st_cost = li[a][b]
    heapq.heappush(q, (st_cost, a, b))
    visited[a][b] = st_cost

    while q:
        cost, y, x = heapq.heappop(q)
        if y == N - 1 and x == N - 1:
            print(f'Problem {problem}: {visited[y][x]}')

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < N:
                # 다음 위치로 이동할 때 드는 비용
                dist = cost + li[ny][nx]

                # 기존 비용과 다음 위치 이동 비용 비교
                if dist < visited[ny][nx]:
                    # 더 작으면 갱신하고 우선순위 큐에 삽입
                    visited[ny][nx] = dist
                    heapq.heappush(q, (dist, ny, nx))
```

## :black_nib: **Review**
계절학기 강의를 보고 다시 풀어보는 A형 기출 문제

## 📡**Link**

https://www.acmicpc.net/problem/4485