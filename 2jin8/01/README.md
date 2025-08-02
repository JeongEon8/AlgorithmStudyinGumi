# [백준- G4] 25195. Yes or yes
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N + M)$

## :round_pushpin: **Logic**
- 더 이상 이동할 수 없는 정점 == 간선이 없는 경우
  - 간선이 없는 정점들 기록하기
- 곰곰이를 만나지 않고 이동할 수 있는 경우 찾기
  - 만약 곰곰이를 만나지 않고 간선이 없는 정점에 도착하면 `yes` 출력
  - 그렇지 않으면 `Yes` 출력
```java
static String bfs() {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(1); // 1
    visited[1] = true;

    // 1번부터 곰곰이가 있으면 무조건 만남
    if (gomgom[1]) {
        return "Yes";
    }

    while (!queue.isEmpty()) {
        int now = queue.poll();
        // 곰곰이를 만나지 않고 더 이상 이동할 곳이 없는 정점에 도착한 경우
        if (edge[now]) {
            return "yes";
        }

        for (int next : graph[now]) {
            if (!visited[next] && !gomgom[next]) {
                visited[next] = true;
                queue.offer(next);
            }
        }
    }
    return "Yes"; // 곰곰이를 만나는 경우
}
```

## :black_nib: **Review**
"곰곰이를 만나지 않는 경우가 존재할 때"임 문제 잘 읽자,,

## 📡**Link**
- https://www.acmicpc.net/problem/25195
