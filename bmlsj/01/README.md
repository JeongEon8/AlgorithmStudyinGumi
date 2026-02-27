# [백준 - G3] 17616. 등수 찾기

## ⏰ **time**

40분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. X보다 등수가 반드시 높은 학생 수: `dfs`
2. X보다 반드시 등수가 낮은 학생 수: `reDfs`
   를 구한다.

- 최소 등수 : `front + 1`
- 최대 등수 : `N - behind`

```java
static void dfs(int cur) {
    visited[cur] = true;

    for (int next : graph[cur]) {
        if (!visited[next]) {
            count++;
            dfs(next);
        }
    }
}

static void reDfs(int cur) {
    visited[cur] = true;

    for (int next : revGraph[cur]) {
        if (!visited[next]) {
            count++;
            reDfs(next);
        }
    }
}
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/17616](https://www.acmicpc.net/problem/17616)
