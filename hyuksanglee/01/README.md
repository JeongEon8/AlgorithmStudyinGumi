# [백준 - G5] 15681. 트리와 쿼리

## ⏰ **time**

40분

## :pushpin: **Algorithm**
- 트리
- dfs

## ⏲️**Time Complexity**

$O(2^n)$

## :round_pushpin: **Logic**
- 트리를 이용해서 자식들을 연결해준다.
```java
for(int i = 0; i<N-1; i++) {
			input = in.readLine().split(" ");
			int U = Integer.parseInt(input[0]);
			int V = Integer.parseInt(input[1]);
			
			if(list[U]== null) {
				Node node = new Node(U,V);
				list[U] = node;
			}else {
				list[U].ch.add(V);
			}
			
			if(list[V]== null) {
				Node node = new Node(V,U);
				list[V] = node;
			}else {
				list[V].ch.add(U);
			}
			
		}
```
- dfs를 활용해서 최상의 부모의 자식들을 탐색한다.
- 젤 마지막 자식부터 올라오면서 간선수를 더해서 저장해준다.
```java
static int dfs(Node node) {
		int count =1;
		check[node.n] = true;
		for(int i = 0; i<node.ch.size(); i++) {
			int num = node.ch.get(i);
			if(!check[num]) {
				count += dfs(list[num]);
			}
		}
		
		arr[node.n]= count;
		return count;
	}
```


## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/15681
