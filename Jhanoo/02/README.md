# [백준 - 골드 3] 1005. ACM Craft

## ⏰**time**

25분

## :pushpin: **Algorithm**

- 위상 정렬 (Kahn's Algorithm)
- DP (DAG에서 목표 건물까지의 최대 비용 = 완료 시간)

## ⏲️**Time Complexity**

$O(T \cdot (N + K))$

## :round_pushpin: **Logic**

1. 각 건물의 건설 시간 `time[]`, 선행 관계를 인접 리스트 `graph`와 진입 차수 `inDegree[]`로 저장합니다.

```
int[] time = new int[N + 1];
List<Integer>[] graph = new ArrayList[N + 1];
int[] inDegree = new int[N + 1];
for (int j = 0; j < K; j++) {
    int u = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());
    graph[u].add(v);
    inDegree[v]++;
}
```

2. 진입 차수가 0인 건물들부터 큐에 넣고, `dp[j] = time[j]`로 초기화합니다.

```
int[] dp = new int[N + 1];
Queue<Integer> q = new ArrayDeque<>();
for (int j = 1; j <= N; j++) {
    if (inDegree[j] == 0) {
        dp[j] = time[j];
        q.offer(j);
    }
}
```

3. 위상 정렬 순서대로 꺼내면서, 각 정점 `u`에서 나가는 간선에 대해 `dp[v] = max(dp[v], dp[u] + time[v])`로 갱신하고, 진입 차수를 줄여 0이 되면 큐에 넣습니다. 목표 건물 `W`를 꺼낸 뒤에는 더 이상 갱신하지 않고 `dp[W]`를 출력합니다.

```
while (!q.isEmpty()) {
    int u = q.poll();
    if (u == W) break;
    for (int v : graph[u]) {
        dp[v] = Math.max(dp[v], dp[u] + time[v]);
        inDegree[v]--;
        if (inDegree[v] == 0) {
            q.offer(v);
        }
    }
}
System.out.println(dp[W]);
```

## :black_nib: **Review**

- 위상 정렬을 복기할 수 있었다.

## 📡 Link

https://www.acmicpc.net/problem/1005
