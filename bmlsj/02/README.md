
# [백준- G4] 1068. 트리

## ⏰  **time**
60분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. 각 노드들 위치에 자식 노드의 인덱스를 저장한다.
2. 제거할 노드가 루트이면, 바로 5번을 실행한다.
3. 제거할 노드의 위치부터 dfs로 자식 노드들을 제거한다.
    - 제거한 노드에는 `[-1]` 만을 남김
4. 제거 노드의 부모 노드에서 제거 노드를 제거한다.
5. 해당 노드의 크기가 0이면 `leaf` 노드라고 판단한다.


```java

if (remove != root) {

	visited = new boolean[N];
	removeNode(remove);
	tree[remove].clear(); // 기존 모든 값 지우기
	tree[remove].add(-1); // -1 추가

    // 부모 노드에서 remove 제거
	for(int i = 0; i < N; i++) { 
	    for (int j = 0; j < tree[i].size(); j++) { 
	    	int num = tree[i].get(j);
	        if (num == remove) { 
	            tree[i].remove(Integer.valueOf(num)); 
	        } 
	    } 
	}
			
	for (int i = 0; i < N; i++) {
		if (tree[i].size() == 0) {
			leaf++;
		}
	}

	System.out.println(leaf);
}

static boolean[] visited;
static void removeNode(int remove) {

	if (!visited[remove]) {
		visited[remove] = true;
		for (int node : tree[remove]) {
			removeNode(node);
		}

		tree[remove].clear();
		tree[remove].add(-1);

	}
}
```

## :black_nib: **Review**
좀 더 트리답게 풀 수 있을지도

## 📡**Link**
- https://www.acmicpc.net/problem/1068

