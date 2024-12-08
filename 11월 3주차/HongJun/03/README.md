# [백준 - G4] 14938. 서강그라운드

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 최단 거리
- 다익스트라
- 플로이드 워셜

## ⏲️**Time Complexity**

$O(v+e)$

## :round_pushpin: **Logic**

- 다익스트라와 플로이드워셜 둘 다 풀수 있는 문제이다.
- 다익스트라로는 우선순위 큐를 써서 (비용, 노드)를 계속 넣어준다.
- 시작 위치의 비용은 0이므로 처음에는 (0, start)를 넣는다.
- 해당 위치와 연결된 노드들을 탐색하여 비용을 비교하고 더 작은 비용으로 바꾼다.
- 이렇게 구현한 다익스트라를 모든 노드를 시작위치로 해서 실행해본다.
- 거리가 수색범위 내에 있는 경우 얻는 아이템수를 더한다.
- 모든 경우에서 얻을 수 있는 아이템 수 중 최대값 출력.
<br/>
아래는 플로이드 워셜 방식 풀이
```python
n, m, r = map(int, input().split()) # 지역 수, 수색범위, 길의 개수
items = list(map(int, input().split()))
INF = int(1e9)

graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(r):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c

for k in range(1, n+1):
    graph[k][k] = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

answer = []
for i in range(1, n+1):
    tmp = 0
    for j in range(1, n+1):
        if graph[i][j] <= m:
            tmp += items[j-1]
    answer.append(tmp)
print(max(answer))
```
## :black_nib: **Review**
두 가지 방식으로 풀어봤다.
## 📡**Link**

https://www.acmicpc.net/problem/14938
