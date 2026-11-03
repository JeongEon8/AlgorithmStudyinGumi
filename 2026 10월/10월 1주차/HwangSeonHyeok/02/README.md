# [PGS - LV2] 159993. 미로 탈출

## ⏰ **time**

	25분

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
레버를 경유하고 출구를 가야하므로 시작부터 레버까지의 최단거리 + 레버에서 출구까지의 최단거리를 구한다.
갈수없는 경우도 체크한다. 
```java
int bfs(String[] maps, Point start, char end){
	int n = maps.length;
	int m = maps[0].length();
	boolean[][] visited = new boolean[n][m];
	Queue<Point> q = new ArrayDeque<>();
	q.add(start);
	visited[start.y][start.x] = true;
	while(!q.isEmpty()){
		Point current = q.poll();
		if(maps[current.y].charAt(current.x)==end){
			return current.step;
		}
		
		for(int i = 0; i<4; i++){
			int nx = current.x+ dx[i];
			int ny = current.y + dy[i];
			if(nx >=0 && ny>=0 && ny<n && nx < m){
				if(!visited[ny][nx] && maps[ny].charAt(nx) !='X'){
					visited[ny][nx] = true;
					q.add(new Point(ny,nx,current.step+1));
				}
			}
		}
	}
	
	return -1;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/159993