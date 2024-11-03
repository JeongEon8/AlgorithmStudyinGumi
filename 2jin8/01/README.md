# [백준- S3] 10451. 순열 사이클
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- DFS로 사이클을 판별하면 되는 문제
- 사이클의 개수를 세야 하므로 사이클이 만들어진다면 사이클 개수를 증가하고 종료하기
```java
static void dfs(int x) {
  // 탐색 완료된 곳이면 종료
  if (done[x]) return;
  // 탐색이 완료되지 않았지만 이미 방문한 곳 ⇒ 사이클 발생
  if (visited[x]) {
    cycle++;
    done[x] = true; // 탐색완료 처리
    visited[x] = false; // 방문처리 취소
    return;
  }

  visited[x] = true;
  dfs(arr[x]);
  visited[x] = false;
  done[x] = true;
}
```

## :black_nib: **Review**
DFS로 사이클을 판별할 때는 배열을 2개 사용해야 한다는 것을 기억하기

## 📡**Link**
- https://www.acmicpc.net/problem/10451
