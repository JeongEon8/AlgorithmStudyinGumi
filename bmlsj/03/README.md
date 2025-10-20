# [백준 - 골드3] 9466. 텀 프로젝트

## ⏰  **time**
60분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. DFS 탐색
    - `visited[i]`: 해당 학생을 방문했는지 여부
    - `finished[i]`: DFS 탐색이 완료된 학생인지 여부
    - DFS 중 아직 `finished`되지 않은 노드를 다시 만나면, 팀 형성
2. 사이클이 발견되면 `count`를 증가
3. `count`를 제외한 나머지가 팀에 속하지 못한 학생 수

```java
static void dfs(int now) {
    visited[now] = true;
    int next = arr[now];

    if (!visited[next]) {
        dfs(next);
    } else if (!finished[next]) {
        // 사이클 감지됨
        count++;
        for (int i = next; i != now; i = arr[i]) {
            count++;
        }
    }

    finished[now] = true;
}
```

## :black_nib: **Review**
처음에 String형으로 입력 받았다가 시간초과 나서 StringToken으로 바꾸기..


## 📡**Link**
- https://www.acmicpc.net/problem/9466
