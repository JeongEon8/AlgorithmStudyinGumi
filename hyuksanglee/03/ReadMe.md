# [백준 - S2] 11725. 트리의 부모 찾기
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 서로 연결된 노드 2차원 배열에 넣기

2. dfs를 사용하여 해당 노드에 하위 노드를 찾기

3. 찾은 하위노드에 상위 노드 입력하기
  
```java
		public static void dfs(int i) {
		
		check[i] = true; // 방문 여부 true
		
		for(int n : arrList.get(i)) {
			if(check[n]== false) { // 방문 하지않았을때 
				result[n]=i; // 해당 노드에 상위노드(i) 입력
				
				dfs(n); // 해당 노드 dfs 탐색시작
			}
		}
	}
```

## :black_nib: **Review**
- 처음에 서로 연결된 부분 2차원 배열에 넣을때 '[]'를 사용했더니 메모리 초과 떴어요
- list 대신 'arrayList<>'를 사용하니 메모리 초과 문제 해결👍


  
