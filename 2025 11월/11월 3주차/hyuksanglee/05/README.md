# [백준 - S1] 그림

## ⏰  **time**
30분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(n × m)$
- n : 세로 길이
- m : 가로 길이

## :round_pushpin: **Logic**
1. 2차원 배열에 그림 정보 입력 받기
2. for문을 돌면서 1이고 방문하지 않았으면 큐에다 담아주기
    -이때 그림수도 증가 시켜줌
3. while로 큐에 빌때까지 돌아준다.
     - 상,하,좌,우 탐색하고 1이고 방문하지 않을경우 큐에 담아준다.
     - 그림의 크기수도 증가
4. 지금까지 그림의 최댓값이랑 비교해서 더 크면 업데이트 시켜줌
```java
  for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] ==1 && !check[i][j]) {
					count++;
					Info info = new Info(i,j);
					check[i][j] = true;
					que.add(info);
					int total = 1;
					while(!que.isEmpty()) {
						Info newInfo = que.poll();
						int ni = newInfo.i;
						int nj = newInfo.j;
						for(int d = 0; d<4; d++) {
							int ci = ni+ di[d];
							int cj = nj + dj[d];
							if(ci<0 || ci>=n || cj<0 || cj>=m) {
								continue;
							}
							
							if(map[ci][cj]==1 && !check[ci][cj]) {
								check[ci][cj] = true;
								total++;
								info = new Info(ci,cj);
								que.add(info);
							}
							
						}
					}
					if(max < total) {
						max = total;
					}
				}
			}
		}
```


## :black_nib: **Review**
- 이클립스로 해서 디버깅을 할수 있어서 틀렸지만 바로 해결할수 있었어요
- 코테도 이클립스로 칠수 있었으면 좋겠다

## 📡**Link**
- https://www.acmicpc.net/problem/1926
