# [백준- S1] 21937. 작업
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N + M)$

## :round_pushpin: **Logic**
- 역방향으로 그래프 정보를 저장한 뒤, target에서부터 BFS 탐색 시작
- `탐색한 작업의 개수 - 1`이 바로 target을 수행하기 전 먼저 해야 하는 작업의 개수
```java
static int bfs(int target) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(target);
    visited[target] = true;

    int count = 0;
    while (!queue.isEmpty()) {
        int now = queue.poll();
        count++;

        for (int next : graph[now]) {
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
            }
        }
    }
    return count - 1;
}
```

## :black_nib: **Review**
위상정렬 문제인줄 알았으나 아녔다. 제발 문제를 잘 읽고 결정하자

## 📡**Link**
- https://www.acmicpc.net/problem/21937
