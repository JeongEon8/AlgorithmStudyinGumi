# [백준 - 골드 3] 14725. 개미굴

## ⏰**time**

35분

## :pushpin: **Algorithm**

- 트라이 (Trie)
- DFS
- TreeMap

## ⏲️**Time Complexity**

$O\left(\sum K \cdot \log M\right)$  
(\(\sum K\): 전체 먹이 정보 개수 합, \(M\): 각 노드의 자식 수)

- 각 먹이 문자열을 Trie에 삽입할 때 `TreeMap`에 접근하므로 $O(log M)$
- 전체 출력은 모든 노드를 한 번씩 DFS 순회하므로 $O(\sum K)$

## :round_pushpin: **Logic**

1. 각 먹이 정보는 루트부터 시작하는 **경로(path)** 이므로 이를 Trie 구조로 저장한다.

2. 각 노드는 자식 먹이들을 가지고 있으며, 문제에서 **사전순 출력**이 필요하므로  
   자식 자료구조를 `TreeMap<String, Node>` 로 구성한다.

3. 입력을 받을 때마다 루트에서 시작하여 먹이 문자열을 순서대로 내려가며  
   이미 존재하면 재사용하고, 없으면 새 노드를 생성한다.

```java
Node cur = root;
for (int j = 0; j < K; j++) {
    String food = st.nextToken();

    cur.child.putIfAbsent(food, new Node());
    cur = cur.child.get(food);
}
```

4. Trie 구성이 끝나면 루트부터 DFS를 수행하면서 깊이에 따라 `"--"` 를 붙여 출력한다.

```java
static void dfs(Node node, int depth) {
    for (Map.Entry<String, Node> entry : node.child.entrySet()) {
        sb.append("--".repeat(depth))
          .append(entry.getKey())
          .append("\n");
        dfs(entry.getValue(), depth + 1);
    }
}
```

5. `TreeMap` 을 사용했기 때문에 DFS 순회만 해도 자식들이 자동으로 **사전순 출력**된다.

## :black_nib: **Review**

- 처음에는 문자열을 정렬해서 출력하는 방식도 생각했지만,  
  부모-자식 관계를 유지하며 계층 구조를 출력해야 하므로 Trie 구조가 더 적절했다.

- 자식 노드를 `TreeMap` 으로 관리하면 별도의 정렬 과정 없이도  
  사전순 출력이 가능해 구현이 깔끔해진다.

- 루트 노드는 실제 먹이 정보를 가지지 않는 **더미 노드**로 두고  
  DFS를 시작하면 구현이 자연스럽다.

## 📡 Link

https://www.acmicpc.net/problem/14725
