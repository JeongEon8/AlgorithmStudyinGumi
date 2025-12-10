# [백준 - G3] 18808. 스티커붙이기

## ⏰  **time**
60분

## :pushpin: **Algorithm**
- 시뮬레이션

## ⏲️**Time Complexity**
$O(N*M*R*C)$

## :round_pushpin: **Logic**
1. 노트북크기 만큼 돌면서 스티커를 붙일수 있는곳을 찾는다. 
```java
for(int n = 0; n<N; n++) {
					for(int m =0; m<M; m++) {
						boolean ch = true;
						check2 :for(int r=0; r<st.length; r++) {
							for(int c = 0; c<st[0].length; c++) {
								if(n+r >=N || m+c>=M) {
									ch = false;
									break check2;
								}
								if(st[r][c]==1 && map[n+r][m+c]==1) {
									ch = false;
									break check2;
								}
							}
						}
						if(ch) {
							for(int r=0; r<st.length; r++) {
								for(int c = 0; c<st[0].length; c++) {
									
									if(st[r][c] == 1) {
										map[n+r][m+c] =st[r][c];
										result -=1;
									}
								}
							}
							break check1;
						}	
					}
				}
```
	- 탐색 구간이 노트북 화면보다 오바할경우와 이미 스티커가 붙여있는 부분이면 패스한다.
2. 노트북을 다 탐색했는데 붙일데가 없으면 90도 회전 시켜 다시 탐색
```java
	static int[][] rotate90(int[][] src) {
        int R = src.length;
        int C = src[0].length;
        int[][] rot = new int[C][R];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                rot[c][R - 1 - r] = src[r][c];
            }
        }
        return rot;
    }
```


## :black_nib: **Review**
- 시뮬레이션 문제는 코드 적을게 많아서 싫어요

## 📡**Link**
- https://www.acmicpc.net/problem/18808
