# [백준 - G5] 100026. 적록색약
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- dfs

## :round_pushpin: **Logic**
1. 이중for문으로 방문 하지 않은 좌표를 찾는다

2. 방문하지 않은 좌표에 색상과 주변에 같은 색상이 있는지 dfs탐색
   	- 탐색할 때 다음 적록색약인 사람을 검사해야하기 때문에 색상이 녹색이면 미리 적색으로 바꾸어준다.
3. 탐색을 완료했으면 result값을 +1 해준다.

4. 이중 for문을 다 돌때까지 1번 반복

5.  적록색약인 사람을 검사해야하기위해 다시 1번 에서 한번더 이중 for문 실행

   
```#java
public static void dfs(int i, int j) {
		for(int d = 0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || ni >=N || nj <0 || nj>=N ) {
				continue;
			}
			
			if(arr[ni][nj].equals(arr[i][j]) && isSelected[ni][nj] == false) {
				isSelected[ni][nj] = true;
				
				dfs(ni,nj);
				if(arr[ni][nj].equals("G")) {
					arr[ni][nj]="R";
				}
			}
			
		}
	}
```
## :black_nib: **Review**

- 처음에는 적록색약이 아닌 사람 검사하는 dfs와 적록색약인 사람을 검사하는 dfs를 따로 만들라고 했지만
- 생각해보니 적록색약이 아닌 사람 검사할때 G를 R로 바꾸면 dfs코드가 같기 때문에 코드길이를 줄일수있었다.

## 📡**Link**

- https://www.acmicpc.net/problem/10026
  
