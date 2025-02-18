# [백준 - 골드 4] 1697. 숨바꼭질
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 큐를 이용해서 BFS 탐색
2. s+1, s-1, s*2 각각 방문 가능한지 확인 후 queue에 추가
```java
// s+1 이동, 범위 확인 및 방문 여부 확인
if (s + 1 <= 100000 && !visited[s + 1]) {
	visited[s + 1] = true;
	queue.offer(new int[] { s + 1, t + 1 });
}

// s-1 이동, 범위 확인 및 방문 여부 확인
if (s - 1 >= 0 && !visited[s - 1]) {
	visited[s - 1] = true;
	queue.offer(new int[] { s - 1, t + 1 });
}

// s*2 이동, 범위 확인 및 방문 여부 확인
if (s * 2 <= 100000 && !visited[s * 2]) {
	visited[s * 2] = true;
	queue.offer(new int[] { s * 2, t + 1 });
}
```

## :black_nib: **Review**
- 꼭꼭 숨어라..

## 📡 Link
https://www.acmicpc.net/problem/1697
