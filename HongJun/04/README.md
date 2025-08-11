# [백준 - S3] 2606. 바이러스

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- DFS, BFS

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
그래프 탐색 기본 문제 다시 풀어보기
BFS로 풀어보았다

```python
visited = [False]*(n+1)

for i in range(1, m+1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def bfs(start):
    queue = deque([start])
    visited[start] = True
    
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/2606
