
# [백준- G4] 3. 미세먼지 안녕! 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(T × R × C)$

## :round_pushpin: **Logic**

- t시간 만큼 미세먼지 조건과 공기청정기 조건에 맞게 실행 해주면 된다.
  	- 미세먼지 먼지가 있는곳에서 해당 먼지 값/5 해준 값을 주변(상, 하, 좌, 우)에 나누어준다.
  	  	- 나누어 줄때는 임시 저장 배열에 저장한다.
  	  	- 맵 전체를 다 돌면 임시로 저장한 배열 먼지값을 현재 map배열에 더해준다.
	- 공기청정기는 바람 방향 반대 방향으로 돌면서 해당값을 이동 시킨다.

```java
	static void dust() {
		int[][] temporary = new int[R][C];
		for(int r =0 ; r< R; r++) {
			for(int c = 0; c< C; c++) {
				if(map[r][c] >1 ) {
					int divide = map[r][c]/5;
					for(int d = 0; d<4; d++) {
						int nr = r+ dr[d];
						int nc = c + dc[d];
						if(nr<0 || nc<0 || nr>=R || nc>= C || map[nr][nc] ==-1) {
							continue;
						}
						temporary[nr][nc] += divide;
						map[r][c] -= divide;
					}
				}
			}
		}
		
		for(int r =0 ; r< R; r++) {
			for(int c = 0; c< C; c++) {
				map[r][c] += temporary[r][c];
			}
		}
		
	}
	
	static void air(int[] r, int[] c) {
	    // 위쪽(반시계)
	    int top = r[0];
	    for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
	    for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
	    for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
	    for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
	    map[top][1] = 0;

	    // 아래쪽(시계)
	    int bottom = r[1];
	    for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
	    for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
	    for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
	    for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
	    map[bottom][1] = 0;
	}
```

## :black_nib: **Review**
- 루모스


## 📡**Link**
- https://www.acmicpc.net/problem/17144

