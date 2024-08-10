# [백준 - G5] 번호. 제목
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## :round_pushpin: **Logic**
- 각 육지에서 BFS 탐색을 수행해서, 현재 지점과 연결된 모든 육지를 탐색하는데 걸리는 최단 시간 구하기
- 각각의 최단 시간 중에서 최댓값이 바로 문제의 정답(=보물이 묻혀 있는 두 곳 간의 최단 거리)
```java
int time = 0;
while (!landList.isEmpty()) {
    int[] land = landList.poll();
    visited = new boolean[N][M];
    time = Math.max(time, bfs(land[0], land[1]));
}
```

## :black_nib: **Review**
복잡해 보였지만 다행히도 각 육지에서 BFS 탐색을 수행하면 되는 문제였다!

## 📡**Link**
- [BOJ 2589_보물섬](https://www.acmicpc.net/problem/2589)
