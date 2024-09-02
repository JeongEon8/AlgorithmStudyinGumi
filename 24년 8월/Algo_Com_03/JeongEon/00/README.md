# [SWEA - D5] 1248. [S/W 문제해결 응용] 3일차 - 공통조상
 
## ⏰  **time**

40분
  
## :pushpin: **Algorithm**

재귀, 트리 탐색
  
## ⏲️**Time Complexity**

$O(N*2)$
    
## :round_pushpin: **Logic**

- 정점 개수 세는 함수
  1. vertics벡터 사이즈가 1일때(부모가 0일 경우) 1을 반환
  2. 자식의 개수 만큼 반복문을 돌며 해당 자식을 부모로 두고 다시 탐색
```cpp
int countVertics(int parent, vector<int> vertics[10001]) {
	if (vertics[parent].size() == 1) {
		return 1;
	}
	else {
		int cnt = 1;
		for (int i = 1; i < vertics[parent].size(); i++) {
			cnt += countVertics(vertics[parent][i], vertics);
		}
		return cnt;
	}
}
```

- 부모 찾는 함수
  1. 해당 정점 벡터의 0번째는 부모의 위치
  2. 위로 올라가면 모든 부모를 큐에 넣는다.
  3. 두 정점의 큐 사이즈를 비교하며 더 큰 쪽에서 부모를 빼 같은지 확인한다.
```cpp
queue<int> findParent(int child, vector<int> vertics[10001]) {
	queue<int> q;
	while (vertics[child][0] != 0) {
		q.push(vertics[child][0]);
		child = vertics[child][0];
	}

	return q;
}
```
  
## :black_nib: **Review**

- 뭔가 더 효율적으로 할 수 있을 거 같은데..?? 
  
## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV15PTkqAPYCFAYD&categoryId=AV15PTkqAPYCFAYD&categoryType=CODE&problemTitle=&orderBy=SUBMIT_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=4
