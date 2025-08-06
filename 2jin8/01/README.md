# [백준- G3] 9470. Strahler 순서
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
위상정렬

## ⏲️**Time Complexity**
$O(N + M)$

## :round_pushpin: **Logic**
- 각 간선으로 들어오는 진입차수 구하기 & 연결 정보 저장하기
  - 자신으로 들어오는 정점들의 순서를 확인해야 하니까 역방향으로도 저장
- 진입 차수가 0인 것들 큐에 넣기
- 큐에서 하나씩 빼면서 그 노드랑 연결된 간선 끊기
  - 간선을 끊어서 진입 차수가 0이 되면 큐에 넣기
  - 이때, 자신으로 들어오는 정점들 순서의 최댓값 & 개수 찾기
  - 최댓값이 2개 이상이면 `최댓값 + 1`, 아니면 `최댓값`
```java
while (!queue.isEmpty()) {
    int now = queue.poll();

    for (int next : graph[now]) {
        // 모든 노드와 연결이 끊어지는 경우
        if (--inDegree[next] == 0) {
            // 최댓값 & 최댓값 개수 구하기
            int max = 0, count = 0;
            for (int before : rgraph[next]) {
                if (max < order[before]) {
                    count = 1;
                    max = order[before];
                } else if (max == order[before]) {
                    count++;
                }
            }

            // 최댓값이 2개 이상이면 최댓값 + 1, 아니면 최댓값
            queue.offer(next);
            order[next] = count > 1? max + 1 : max;
        }
    }
}
```

## :black_nib: **Review**
완전한 위상정렬이 아니니까 순서의 최댓값을 직접 구해줘야 한다!

## 📡**Link**
- https://www.acmicpc.net/problem/9470
