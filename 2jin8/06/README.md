# [SWEA - D5] 1248. 공통조상 
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
트리 / BFS

## :round_pushpin: **Logic**
- 각 자식의 부모는 하나이므로 배열을 이용해서 공통 조상 찾기
- BFS 탐색을 이용해서 서브 트리 개수 세기
```java
static int getSubTree(int parent) {
	Queue<Integer> queue = new ArrayDeque<>();
	queue.offer(parent);

	int total = 0;
	while (!queue.isEmpty()) {
		int now = queue.poll();
		total++;

		for (int i = 0; i < findChildren[now].size(); i++) {
			queue.offer(findChildren[now].get(i));
		}
	}
	return total;
}
```

## :black_nib: **Review**
배열을 이용해서 부모를 기록하고, ArrayList를 이용해서 자식을 기록했다. <br/>
사실 공통 조상을 찾는 것을 단순하게 구현해서 시간 초과가 날 줄 알았는데 생각보다 시간을 많이 소요되지 않아서 다행이었다ㅎ

## 📡**Link**
- [SWEA 1248_공통조상](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD)
