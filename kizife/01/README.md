# [백준] 1743. 음식물 피하기 
 
## ⏰  **time**
20분 

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
O(N*M)

## :round_pushpin: **Logic**
음식물이 있는 곳에 숫자 1을 삽입한다.
```java
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 1;
		}
```

dfs를 돌리며, 다음 좌표로 전진할 때마다 count(넓이)를 ++ 해준다.
```java
		count++;
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || arr[x][y] == 0) continue;
			dfs(x, y);
		}
```

구한 count 중 가장 큰 것을 answer로 지정해 출력한다.


## :black_nib: **Review**
- 평범한 dfs 문제였다.

## 📡**Link**
- https://www.acmicpc.net/problem/1743
