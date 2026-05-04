# [PGS - lv2] 전력망을 둘로 나누기

## ⏰**time**

30분

## :pushpin: **Algorithm**

DFS, 완전탐색

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

0 ~ n까지 노드 하나씩 끊어보고, 가장 차이가 작은 값을 리턴한다.

1. 모든 전선을 하나씩 끊어보면서 그래프를 다시 만든다. (해당 idx 제외)
2. DFS 한 번으로 한 쪽 네트워크의 노드 개수(cnt)를 구한다.
3. 나머지 노드(`n - cnt`)와의 차이를 계산해서 최소값을 갱신한다.

```java
int idx = 0;
while(idx < n) {
    visited = new boolean[n + 1];
    for(int i = 1; i <= n; i++) {
        if (!visited[i]) {
            cnt = 1;
            visited[i] = true;
            dfs(i);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
    }
    idx++;
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/86971>
