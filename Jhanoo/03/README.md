# [백준 - 골드 3] 2623. 음악프로그램

## ⏰**time**

18분

## :pushpin: **Algorithm**

- 그래프
- 위상 정렬 (Kahn's Algorithm)

## ⏲️**Time Complexity**

$O(N + M)$  
(\(N\): 가수 수, \(M\): PD 수, 각 간선은 한 번씩만 처리)

## :round_pushpin: **Logic**

1. 각 PD가 제시한 순서를 그래프의 간선으로 변환하고, 진입 차수를 계산합니다.  
   예를 들어 `a b c`라면 `a → b`, `b → c` 간선을 추가합니다.

```java
List<Integer>[] graph = new ArrayList[N + 1];
for (int i = 1; i <= N; i++) {
    graph[i] = new ArrayList<>();
}
int[] inDegree = new int[N + 1];

for (int i = 0; i < M; i++) {
    int n = Integer.parseInt(st.nextToken());
    int u = Integer.parseInt(st.nextToken());
    for (int j = 1; j < n; j++) {
        int v = Integer.parseInt(st.nextToken());
        graph[u].add(v);
        inDegree[v]++;
        u = v;
    }
}
```

2. 진입 차수가 0인 정점(앞에 와야 할 가수가 없는 가수)들을 큐에 넣고, 위상 정렬을 시작합니다.

```java
Queue<Integer> q = new ArrayDeque<>();
for (int i = 1; i <= N; i++) {
    if (inDegree[i] == 0) {
        q.offer(i);
    }
}
```

3. 큐에서 하나씩 꺼내어 결과 순서에 추가하고, 해당 정점에서 나가는 간선의 도착 정점들의 진입 차수를 1씩 줄입니다. 이때 진입 차수가 0이 되는 정점은 다시 큐에 넣습니다.

```java
int cnt = 0;
StringBuilder sb = new StringBuilder();
while (!q.isEmpty()) {
    int u = q.poll();
    cnt++;
    sb.append(u).append("\n");

    for (int v : graph[u]) {
        if (--inDegree[v] == 0) {
            q.offer(v);
        }
    }
}
```

4. 모든 정점이 결과에 포함되었다면(사이클이 없다면) 구한 순서를 출력하고,  
   일부만 처리되었다면(사이클 존재) 0을 출력합니다.

```java
if (cnt < N) System.out.println(0);
else System.out.print(sb);
```

## :black_nib: **Review**

- 지난 번에 한 위상정렬이 떠올라서 쉽게 풀었다.

## 📡 Link

https://www.acmicpc.net/problem/2623
