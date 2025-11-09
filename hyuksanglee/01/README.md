# [백준 - G3] 17182. 우주 탐사선

## ⏰  **time**
60분

## :pushpin: **Algorithm**
- 플로이드
- dfs

## ⏲️**Time Complexity**
$O(Y*N*M)$

## :round_pushpin: **Logic**
1. 플로이드를 사용해서 각 지점의 최소시간 구하기
```java
 for(int k = 0; k<N; k++) {
			for(int n = 0; n<N; n++) {
				for(int m = 0; m<N; m++) {
					if(map[n][m] > map[n][k]+map[k][m]) {
						map[n][m] = map[n][k]+map[k][m];
					}
				}
				
			}
		}
```
2. dfs를 통해 모든점을 다 돌았을때 최소시간 구하기
```java
            static void dfs( int n, int sum, int count) {
		if (sum >= best) return;
        if (count == N) {
            best = Math.min(best, sum);
            return;
        }
        
		for(int i = 0; i<N; i++) {
			
			if(!check[i]) {
				check[i] = true;
				int total = sum+map[n][i];
				count++;
				dfs(i,total,count);
				count--;
				check[i] = false;
			}
		}
		
	}
```


## :black_nib: **Review**
- 처음에는 dp로 풀어볼까 생각했다가 도저히 못하겠어서 dfs를 풀었어요

## 📡**Link**
- https://www.acmicpc.net/problem/17182
