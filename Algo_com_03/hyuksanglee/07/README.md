# [SWEA - D5] 1248. 공통조상

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- dfs

## ⏲️**Time Complexity**

$O(V*E)$

## :round_pushpin: **Logic**

1. 배열에 각정점에 바로 위 정점에 어떤 정점인지 넣어준다.

2. 찾고자 하는 두 정점에 dfs를 이용하여 각 정점에 조상정점을 check배열에 더해준다.
   	- 1-> 5 -> 3 인 트리에서 3을 예로 들면 check 함수에는

|1|2|3|4|5|
|---|---|---|---|---|
|1|0|1|0|1|
 3. 두번째 정점에서 조상정점을 찾을때에는 +1을 할때 2가 되면 공통조상이므로 리턴해준다.
 
 4. 공통조상을 찾으면 자식을 dfs로 찾아준다.
    - for문을 돌아 공통조상 정점의 자식 정점을 찾아 count에 +1해주고 큐에 담는다
    - 큐에서 정점 하나를 빼서 for문을 돌면서 자식 정점을 큐에 담고 count+1을 해준다.
    - 위 방법을 큐에 아무것도 없을때 까지 반복한다.
 

```java
   // 부모 찾기
	static void dfs(int n) {
		if(arr[n] == n) { // 부모가 자기 자신일때
			return;
		}
		
		check[arr[n]] +=1;	// 공통 조상을 찾기 위해 방문 여부 체크
		
		if(check[arr[n]] == 2) {	// 2이면 공통 조상이므로 리턴
			return;
		}
		
		dfs(arr[n]);	// 
	}

// 자식 찾는 함수
	static void rdfs(int n ) {
		Queue<Integer> que = new LinkedList<>(); 
		que.offer(n);
		
		
		while(!que.isEmpty()) {
			int num = que.poll();
			for(int v = 1; v<=V; v++) {
				if(v==num) {	// 자기자신을 제외하기 위해
					continue;
				}
				if(arr[v] == num) {	// 부모가 num인 정수 찾기
					count++;
					que.offer(v);	// num자식인 정수 큐에 담기
				}
			}
		}
		
	}
```

## :black_nib: **Review**

- 시간 초과 될거 같았지만 다행히 통과

## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD
