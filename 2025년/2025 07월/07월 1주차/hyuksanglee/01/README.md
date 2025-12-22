# [백준- G3] 14442. 벽 부수고 이동하기 2
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N × M × K)$

## :round_pushpin: **Logic**
- bfs를 사용해서 최적의 경로를 찾는다
  	1. 해당 위치, 벽을 부술수 있는 스킬수, 현재까지 이동횟수를 담는 클래스를 생성한다.
  	2. map 정보를 담는 2차원 배열과 해당 지역에 스킬을 사용횟수에 따라 방문했는지 체크하는 3차원 배열을 만들어 둔다.
  	3. bfs 탐색
  		1. 좌표: (0,0), 스킬수 : K, 이동횟수 : 0으 정보 클래스에 담아서 큐에 넣어준다.
  		2. 큐에서 값을 하나씩 뽑고 상하좌우 주변을 탐색해서 0이면 큐에 담고, 1이면 벽을 부수는 스킬이 있으면 담아준다.
  	    		- 탐색할때 한번 방문을 했으면 넘겨준다.
  	 	4. 좌표를 하나씩 뽑는데 (N,M)이면 count값을 출력한다.

```java
	static void bfs() {
		que.add(new Info(0, 0, K,1));
		while(!que.isEmpty()) {
			Info newInfo = que.poll();
			int x = newInfo.x;
			int y = newInfo.y;
			int skill = newInfo.skill;
			if(x==M-1 && y== N-1) {
				result = newInfo.count;
				return;
			}
			for(int d =0; d<4; d++) {
				int newX = x+dx[d];
				int newY = y+dy[d];
				
				if(newY <0 || newX <0 || newY>=N || newX>=M) {
					continue;
				}
				if(map[newY][newX]==0 && !isVisited[newY][newX][skill]) {
					isVisited[newY][newX][skill] = true;
					Info inputInfo = new Info(newX, newY, skill, newInfo.count+1);
					que.add(inputInfo);
				}else if(map[newY][newX]==1 && skill>0 && !isVisited[newY][newX][skill - 1]) {
					isVisited[newY][newX][skill-1] = true;
					Info inputInfo = new Info(newX, newY, skill-1, newInfo.count+1);
					que.add(inputInfo);
				}
			}
		}
	}
```

## :black_nib: **Review**
- 1학기에 알고리즘으로 풀었던 말숭이문제랑 비슷해서 쉽게 풀었어요

## 📡**Link**
- https://www.acmicpc.net/problem/14442
