# [백준- S2] 1058. 친구
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
- 깊이가 최대 2인 친구들의 수를 세면 됨
- 그 중 가장 많은 친구의 수를 출력하면 끝
  - 각각 BFS를 돌려야 함
```java
int friend = 0, depth = 0;
while (!queue.isEmpty()) {
  int size = queue.size();
  for (int i = 0; i < size; i++) {
    int now = queue.poll();
    friend++;

    for (int next : graph[now]) {
      if (!visited[next]) {
        queue.offer(next);
        visited[next] = true;
      }
    }
  }
  // 깊이가 2 이하인 친구들의 수만 세면 됨
  if (depth++ == 2)
    break;
}
```

## :black_nib: **Review**
간단한 BFS 문제!

## 📡**Link**
- https://www.acmicpc.net/problem/1058
