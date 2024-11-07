# [백준 - G4] 1976. 여행 가자
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 각 도시가 연결 되었는지 여부를 받는 2차원 배열 생성, 연결되어 있는지 확인하고 싶은 도시를 담는 1차원 배열 생성, bfs를 탐색할때 방문 여부를 담는 2차원 배열 생성
- bfs를 통해 1차원 배열 0번째 인덱스를 시작으로 bfs 탐색
    - 해당 인덱스에서 for문을 돌아 1이 있으면 큐에 담고 방문처리해줌
- bfs 탐색이 끝나고 방문 여부를 담는 2차원 배열을 for문으로 연결 되어있는지 확인하는 도시가 방문 되었는지 확인하고 하나라도 연결 안되어있으면 "NO"를 출력한다.
```java
public static void bfs(int nu) {
		Queue<Integer> que = new ArrayDeque();
		que.add(nu);
		while(!que.isEmpty()) {
			
			int num = que.poll();
			isSelected[num] = true;
			for(int n =0; n<N; n++) {
				if(arr[num][n]==1 && isSelected[n]==false) {
					que.add(n);
					isSelected[n]=true;
				}
				
			}
			
		}
	}

```

## :black_nib: **Review**
- 처음에 문제 이해를 잘못해서 헤맸어요

## 📡**Link**
- https://www.acmicpc.net/problem/1976
