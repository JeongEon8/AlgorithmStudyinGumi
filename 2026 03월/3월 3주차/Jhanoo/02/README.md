# [백준 - 골드 3] 1238. 파티

## ⏰**time**

27분

## :pushpin: **Algorithm**

- 다익스트라 (Dijkstra)
- 역방향 그래프 (Reverse Graph)
- 최단 거리 합의 최댓값

## ⏲️**Time Complexity**

$O((N + M) \log N)$  
(`dijkstra`를 2번 수행)

## :round_pushpin: **Logic**

1. 입력 간선을 원래 그래프 `graph(u -> v)`로 저장하고, 동시에 역방향 그래프 `reverseGraph(v -> u)`도 함께 만듭니다.

```java
List<Edge>[] graph = new ArrayList[N + 1];
List<Edge>[] reverseGraph = new ArrayList[N + 1];

for (int i = 1; i <= N; i++) {
    graph[i] = new ArrayList<>();
    reverseGraph[i] = new ArrayList<>();
}

for (int i = 0; i < M; i++) {
    st = new StringTokenizer(br.readLine());
    int u = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    graph[u].add(new Edge(v, t));
    reverseGraph[v].add(new Edge(u, t));
}
```

2. `X`에서 시작해 원래 그래프 `graph`로 다익스트라를 돌려 `go[i] = X -> i` 최단 거리를 구합니다.

```java
int[] go = dijkstra(graph, X, N);
```

3. `X`에서 시작해 역그래프 `reverseGraph`로 다익스트라를 돌리면, `back[i] = i -> X` 최단 거리를 얻을 수 있습니다.

```java
int[] back = dijkstra(reverseGraph, X, N);
```

4. 각 학생 `i`에 대해 왕복 최단거리 `go[i] + back[i]`를 구하고 최댓값을 답으로 출력합니다.

```java
int ans = 0;
for (int i = 1; i <= N; i++) {
    ans = Math.max(ans, go[i] + back[i]);
}
System.out.println(ans);
```

## :black_nib: **Review**

- 휴..

## 📡 Link

https://www.acmicpc.net/problem/1238
