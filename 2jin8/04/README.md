# [백준- S2] 5567. 결혼식
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(V + E)$

## :round_pushpin: **Logic**
- 친구의 친구까지만 초대 가능
- 따라서 깊이가 2일 때까지 방문 가능한 사람들만 초대 가능함
  - 큐 사이즈만큼 반복하도록 해서 깊이 세기
```java
static void bfs(int start) {
  Queue<Integer> queue = new ArrayDeque<>();
  queue.offer(start);
  visited[start] = true;

  int depth = 0, ans = 0;
  while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
      int now = queue.poll();
      ans++;

      for (int next : graph[now]) {
        if (!visited[next]) {
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
    if (depth++ == 2) { // 친구의 친구까지만 초대
      break;
    }
  }
  System.out.println(ans - 1); // 자기 자신은 빼야 함
}
```

## :black_nib: **Review**
오랜만에 BFS! 간단한 문제였다.

## 📡**Link**
- https://www.acmicpc.net/problem/5567
