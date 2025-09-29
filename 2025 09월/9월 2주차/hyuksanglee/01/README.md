
# [백준- G5] 2660. 회장뽑기
## ⏰  **time**
50분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**

- 인접 행렬로 두 지점을 입력 받으면 두곳 다 연결처리
	- ex) A - B 이면 arr[A][B] = true, arr[B][A] = true
- for문을 돌면서 하나씩 bfs를 탐색해주고 최장거리를 저장해준다.
```java
	for(int i =1; i<N+1; i++) {
			boolean[] isCheck = new boolean[N+1];
			int count =0;
			Queue<Friend> que = new ArrayDeque();
			
			que.add(new Friend(i,0));
			while(!que.isEmpty()) {
				Friend friend = que.poll();
				isCheck[friend.f]= true;
				for(int j = 1; j<N+1; j++) {
					if(!isCheck[j] && arr[friend.f][j]) {
						que.add(new Friend(j,friend.count+1));
						isCheck[j]= true;
						if(total[i]<friend.count+1) {
							total[i]=friend.count+1;
						}
					}
				}
			}
		}
```

- 각각의 초기점의 최장거리들을 비교해서 최솟값을 출력 해준다.
```java
	int result = Integer.MAX_VALUE;
		int co = 0;
		for(int i = 1; i<N+1; i++) {
			if(result >total[i]) {
				result =total[i];
				co=0;
			}
			if(result ==total[i]) {
				co++;
			}
		}
		
		System.out.println(result+" "+co);
		for(int i = 1; i<N+1; i++) {
			
			if(result ==total[i]) {
				System.out.print(i+" ");
			}
		}
```

## :black_nib: **Review**
- bfs,dfs로 푸는거는 이제 쉽네요


## 📡**Link**
- https://www.acmicpc.net/problem/2660

