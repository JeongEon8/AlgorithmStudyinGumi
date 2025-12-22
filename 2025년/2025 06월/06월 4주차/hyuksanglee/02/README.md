# [백준- G4] 2636. 치즈
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(K × N × M)$

## :round_pushpin: **Logic**
- 치즈 외부랑 맞닿는 부분을 찾기 위해 bfs를 사용해 0,0 에 이어진 부분(공기)과 치즈부분을 찾아 치즈 부분 변경해준다.
  	1. 0,0을 큐에 넣는다
  	2. 큐에서 한개 꺼내고 주변(상, 하, 좌, 우) 탐색을 하고 0이면 큐에 추가하고 1이면 0으로 변경 (0이든 1이든 방문처리)
  	3. 탐색을 다했을 때 1->0 변경 개수가 0이 아니면 1~2 반복 0이면 결과값 출력

```java
	// bfs
	while(!que.isEmpty()) {
				Place newData = que.poll();
				
				for(int d = 0; d<4; d++) {
					int h = newData.he + dh[d];
					int w = newData.we + dw[d];
					if(h<0 || w<0 || h>=height || w>=weight) {
						continue;
					}
					if(isVisited[h][w] == count) {
						continue;
					}
					
					isVisited[h][w] = count;
					if(map[h][w]==0) {
						
						Place inputData = new Place(h,w);
						que.add(inputData);
					}
					if(map[h][w]==1) {
						total++;
					}
					map[h][w]=0;
					
					
				}
				
			}
```

## :black_nib: **Review**
- 처음에는 0 탐색 개수가 N*M 일때까지 하려고 했지만 메모리 낭비라는 생각이 들어 1탐색 개수로 변경했어요

## 📡**Link**
- https://www.acmicpc.net/problem/2636
