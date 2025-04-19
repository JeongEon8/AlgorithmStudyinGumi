# [백준 - 골드 5] 17836. 공주님을 구해라!
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N×M)$

## :round_pushpin: **Logic**
1. 그람을 가질 때와 안 가질 때를 구분하기 위한 class 정의
```java
static class Node {
  int x;
  int y;
  int hasSword; // 0이 없는 거, 1이 있는 거 

  public Node( int hasSword, int x, int y) {
    this.x = x;
    this.y = y;
    this.hasSword = hasSword;
  }
}
```
2. Queue에 이동 가능한 지점들 삽입
3. 현재점 기준 상하좌우로 탐색
4. 지도 밖이거나 이동할 수 없는 경우에는 continue
```java
if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 지도 밖

if((start.hasSword == 0 && maps[nx][ny] == 1) || visited[start.hasSword][nx][ny] != 0) continue; // 이동할 수 없음
```
5. 방문하지 않았고 이동할 수 있는 경우는 queue에 추가하고 방문기록 갱신
```java
if((start.hasSword == 0 && maps[nx][ny] == 2) || start.hasSword == 1 ) { // 그람을 획득했거나 소지하고 있는 경우
  queue.add(new Node(1, nx, ny));
  visited[1][nx][ny] = visited[start.hasSword][start.x][start.y] + 1;
} else if(start.hasSword == 0 && maps[nx][ny] == 0) {
  queue.add(new Node(start.hasSword, nx, ny));
  visited[start.hasSword][nx][ny] = visited[start.hasSword][start.x][start.y] + 1;
}
```

## :black_nib: **Review**
- 오랜만에 골드 풀려니까 힘들다

## 📡 Link
https://www.acmicpc.net/problem/17836
