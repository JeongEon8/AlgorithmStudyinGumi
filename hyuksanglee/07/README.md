# [백준 - G4] 2458. 키순서

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- 플로이드

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

1. 3중 for문을 써서 정점 한부분이 모든 정점에 연결이 되어있는지 확인 한다.

2. 거치는 정점, 시작점, 도착점 순으로 for문을 돌려준다.

```java
    for(int k =1; k<=N; k++) {
			for(int i =1; i<=N; i++) {
				for(int j =1; j<= N; j++) {
					if(arr[i][k] && arr[k][j]) {
						arr[i][j] = true;
					}
				}
			}
		}
```

## :black_nib: **Review**

- 처음에는 dfs를 사용해서 각 정점에 연결되어 있는 부분을 찾으려고 했지만 시간 초과가 떠서 실패했습니다.

## 📡**Link**

- https://www.acmicpc.net/problem/2458
