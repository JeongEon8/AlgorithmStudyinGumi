# [백준 - 골드 5] 15681. 트리와 쿼리

## ⏰**time**
47분

## :pushpin: **Algorithm**
- 트리
- DFS (깊이 우선 탐색)
- DP

## ⏲️**Time Complexity**
$O(N+Q)$

## :round_pushpin: **Logic**
1. 인접 리스트를 사용하여 트리 구조를 표현합니다.
```
graph = new ArrayList[N + 1];
for (int i = 0; i < N - 1; i++) {
    int U = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    graph[U].add(V);
    graph[V].add(U);
}
```

2. 스택을 사용한 DFS로 루트부터 트리를 순회하며 방문 순서를 저장합니다.
```
Stack<Integer> stack = new Stack<>();
stack.push(root);
parent[root] = -1;

while (!stack.isEmpty()) {
    int u = stack.pop();
    order[idx++] = u;
    
    for (int v : graph[u]) {
        if (v == parent[u]) continue; // 부모 노드는 건너뛰기
        parent[v] = u;
        stack.push(v);
    }
}
```

3. 역순으로 순회하며 각 노드의 서브트리 크기를 계산합니다. 자식 노드들의 서브트리 크기를 합산하여 자신의 서브트리 크기를 구합니다.
```
for (int i = idx - 1; i >= 0; i--) {
    int u = order[i];
    int size = 1;
    
    for (int v : graph[u]) {
        if (v == parent[u]) continue;
        if (parent[v] == u) size += sub[v]; // 자식 서브트리 크기 더하기
    }
    sub[u] = size;
}
```

4. 각 쿼리에 대해 미리 계산된 서브트리 크기를 출력합니다.
```
for (int i = 0; i < Q; i++) {
    int v = Integer.parseInt(br.readLine());
    sb.append(sub[v]).append("\n");
}
```

## :black_nib: **Review**
- 처음에는 쿼리마다 BFS로 서브트리를 순회하려 했지만, 시간 복잡도가 커져서 DP로 처리했다.

## 📡 Link
https://www.acmicpc.net/problem/15681
