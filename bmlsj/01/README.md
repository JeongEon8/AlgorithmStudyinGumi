# [백준 - 골드2] 19238. 스타트 택시

## ⏰ **time**

120분

## :pushpin: **Algorithm**

- BFS
- 구현

## ⏲️**Time Complexity**

$O(M × N²)$

## :round_pushpin: **Logic**

```java
// 1. 택시 위치에서 BFS로 가장 가까운 승객 탐색
Point target = findPassengers();

// 2. 연료 확인 후 승객 위치까지 이동
fuel -= target.dis;

// 3. 승객 → 목적지 BFS 이동
int dist = bfs(target.x, target.y, passengers[idx][2], passengers[idx][3]);

// 4. 이동 후 연료 보충
fuel -= dist;
fuel += dist * 2;
```

## :black_nib: **Review**

시간초과 났는데 택시 위치에서 BFS를 한 번만 수행하여 가장 가까운 승객을 찾아야 한댄다. 헐랭스 Point에 idx까지 넣어서 정렬

탐색 중 현재 위치에 승객이 있으면 후보 리스트에 추가하고, 최소 거리(minDist)를 갱신하여 그보다 먼 탐색은 중단한다. 이렇게 하면 불필요한 탐색을 줄이면서 문제에서 요구하는 거리 → 행 → 열 우선순위 조건까지 정확하게 처리할 수 있다.

## 📡**Link**

<https://www.acmicpc.net/problem/19238>
