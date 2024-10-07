# [백준] 11403. 경로 찾기
 
## ⏰  **time**
30분 

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
O(N^3)

## :round_pushpin: **Logic**
```java
			// i번째 정점부터 탐색하기 위해 큐에 삽입함 
			queue.offer(i);
```

현재 탐색중인 정점을 tmp로 지정.
```java
				// tmp에서 연결된 모든 정점들을 확인함
				for(int j = 0; j < n; j++) {
					// tmp에서 j로 연결된 경로가 있고 + 아직 방문하지 않은 경우
					if(map[tmp][j] == 1 && visited[j] != true) {
						// j 정점을 큐에 추가 + 방문 처리
						queue.offer(j);
						visited[j] = true;
						
						// i번째 정점 -> j번째 정점으로 갈 수 있음을 기록
						result[i][j] = 1; // 갈 수 있으면 1로 표시
					}
				}
```

결과를 출력한다.

## :black_nib: **Review**
- 시간이 얼마 안 걸리는 dfs, bfs 실버 문제들만 풀어서 양심에 찔린다. 다음주에는 조금 더 힘내보도록 하겠습니다. 아자아자... 

## 📡**Link**
- https://www.acmicpc.net/problem/11403 
