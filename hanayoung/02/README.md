# [백준 - G5] 13549. 숨바꼭질 3

## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 범위와 방문여부를 확인하여 방문 값 업데이트, queue에 추가
```java
            if ((cur + 1 >= MIN_POINT && cur + 1 <= MAX_POINT) && (visited[cur+1] == 0 || visited[cur + 1] > visited[cur])) {
                queue.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
            }
            if ((cur - 1 >= MIN_POINT && cur - 1 <= MAX_POINT) && (visited[cur-1] == 0 || visited[cur - 1] > visited[cur])) {
                queue.add(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
            }
            if ((cur * 2 >= MIN_POINT && cur * 2 <= MAX_POINT) && (visited[cur*2] == 0 || visited[cur*2] > visited[cur])) {
                queue.add(cur*2);
                visited[cur*2] = visited[cur];
            }
```
2. 동생의 위치에 도달하면 탈출
```java
            if (cur == K) {
                queue.clear();
                break;
            }
```

## :black_nib: **Review**
- 오랜만에 푸는 BFS 오랜만이라 그런가 헷갈린당

## 📡 Link
https://www.acmicpc.net/problem/13549
