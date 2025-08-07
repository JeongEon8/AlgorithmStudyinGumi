# [백준- S2] 1326. 폴짝폴짝
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- BFS 탐색으로 최단 거리 구하기
- 징검다리에 적힌 수의 배수만큼 떨어진 곳으로 갈 수 있음 == 1이 적혀있다면 1, 2, 3, … 떨어진 곳으로 갈 수 있음
  - 앞으로 이동하는 경우 & 뒤로 이동하는 경우 모두 확인해야 함
```java
while (!queue.isEmpty()) {
    int now = queue.poll();
    if (now == B) {
        return dist[B] - 1;
    }

    // 징검다리에 적힌 수의 배수만큼 떨어진 곳으로 갈 수 있음
    // 앞으로 이동
    for (int i = 1; i <= N; i++) {
        int move = now + jump[now] * i;
        if (move > N) break;

        if (dist[move] == 0) {
            queue.offer(move);
            dist[move] = dist[now] + 1;
        }
    }

    // 뒤로 이동
    for (int i = 1; i <= N; i++) {
        int move = now - jump[now] * i;
        if (move <= 0) break;

        if (dist[move] == 0) {
            queue.offer(move);
            dist[move] = dist[now] + 1;
        }
    }
}
```

## :black_nib: **Review**
앞으로 이동하는 것만 생각해서는 안됐다,, 

## 📡**Link**
- https://www.acmicpc.net/problem/1326
