# [백준 - G1] 7576. 토마토
## ⏰  **time**
50분

## :pushpin: **Algorithm**
- bfs

## :round_pushpin: **Logic**
1. 데이터를 입력 받을때 토마토가 있는 지역을 queue에 리스트로 넣어준다.
   - list : {토마토의 x좌표, 토마토의 y좌표, 일수}
2. bfs를 통해 queue에서 토마토의 데이터를 한개씩 뽑고 주변(상,하,좌,우)를 확인해서 0이면 queue에 일수를 +1해서 넣어 준다.

3. 그리고 해당칸을 일수 +1로 채워준다.

4. bfs 탐색이 끝나면 0이 있는지 확인하고 0이 있으면 -1을 출력하고

5. 없으면 최댓값에서 -1한 값을 출력한다.
   - 첫날은 일수에 포함 안해서

```#java
public static void bfs() {
		while (!que.isEmpty()) {
			int[] q = que.poll();
			int x = q[0];
			int y = q[1];
			int b = q[2];
			
			for(int i = 0; i<4; i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=M || ny <0|| ny >= N) {
					continue;
				}
				if(arr[ny][nx] ==0) {
					arr[ny][nx] = b+1;
					place = new int[3];
					place[0]=nx;
					place[1]=ny;
					place[2]= b+1;
					que.offer(place);
				}
				
			}
			
		}
	}
```
## :black_nib: **Review**

- 처음에는 토마토 위치를 큐에 안 담고 for문으로 1인 곳을 찾아 거기서 bfs를 시작했지만 2개 이상부터 답이 틀리더라구요

## 📡**Link**

- https://www.acmicpc.net/problem/7576
  
