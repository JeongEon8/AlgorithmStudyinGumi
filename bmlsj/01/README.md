# [PGS - LV3] 01\_네트워크

## ⏰**time**

30분

## :pushpin: **Algorithm**

DFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 0번부터 $n-1$번 노드까지 순회하며 방문하지 않은 노드(`!visited[i]`)가 발견되면, 새로운 네트워크의 시작점으로 간주하고 answer를 1 증가
2. 해당 노드에서 시작하여 `dfs(i)`를 호출하며, 인접 리스트(`graph[v]`)를 통해 연결된 모든 노드를 재귀적으로 방문 처리(`visited[next] = true`)하여 하나의 네트워크로 묶어줌

```java
visited = new boolean[n];
for(int i = 0; i < n; i++) {
    if (!visited[i]) {
        visited[i] = true;
        dfs(i);
        answer++;
    }
}

static void dfs(int v) {

    for(int next: graph[v]) {
        if (!visited[next]) {
            visited[next] = true;
            dfs(next);
        }
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java>
