# [백준] 14940. 쉬운 최단거리 
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
//bfs 구현 
if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
  if (map[nx][ny] == 1) { // 방문할 수 있는 점인지 확인
    queue.add(new Point(nx, ny)); // 다음 점 큐에 추가
    map[nx][ny] = map[nowX][nowY] + 1; // 현재 점에서의 거리 업데이트
  }
}
```

```java
if (map[i][j] != 0) {
  map[i][j] = map[i][j] - 2; // 탐색한 점을 0으로 초기화
}
```

## :black_nib: **Review**
- 어렵지 않은 문제였다~

## 📡**Link**
- https://www.acmicpc.net/problem/14940
