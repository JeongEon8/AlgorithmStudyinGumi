# [SWEA - D4] 3124. 최소 스패닝 트리

## ⏰  **time**
3시간

## :pushpin: **Algorithm**
프림 알고리즘

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 이어지는 정점과 가중치를 담는 class 생성.
2. 해당 class를 타입으로 갖는 ArrayList 생성
3. 해당 ArrayList에 연결 정보 담기
4. 0번부터 우선순위큐에 담기
5. 이어지는 정점들 큐에 담아서 돌면서 방문처리하고 가중치 저장.  


## :black_nib: **Review**
쉬운 문제라고 생각해서 냅다 들이댔다가 완전 대차게 까였고........
갑자기 이상한 데에 꽂혀서 시간 많이 썼다...
크루스칼 알고리즘을 이용해서 푸는데, Union&Find 안쓰고, 우선순위큐를 써서 냅다 가능한 간선을 다 넣고, 작은 것부터 꺼내면서, 사용된 정점들의 방문처리를 하면 싸이클 없이 되지않을까? 라고 생각해서
여기에 완전 꽂혀있어서 겨우 빠져나왔다.....
반례 -> 
1 2 10
1 3 5
2 3 15
2 4 2
3 4 40
일 경우 2-4와 연결되고, 1-3은 연결되어있는데 두 집합은 연결이 안되는 문제...


## 📡 Link
[https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb)
