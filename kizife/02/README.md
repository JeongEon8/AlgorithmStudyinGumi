# [백준] 1926. 그림  
 
## ⏰  **time**
40분 

## :pushpin: **Algorithm**
dfs, bfs  

## ⏲️**Time Complexity**
O(n * m)

## :round_pushpin: **Logic**
1. 모든 좌표를 탐색하며, 아직 방문하지 아니한 경우 + 값이 1인 경우를 찾는다.
```java
	        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    count++;  // 그림 개수 증가
                    draw(i, j);  // 현재 그림을 모두 탐색 (DFS)
                    max = Math.max(max, result);  // 가장 큰 그림 크기 갱신
                    result = 0;  // 다음 그림 크기를 위해 result 초기화
                }
            }
        }
```

2. 한 그림 탐색시 dfs 함수 (그림 크기 구하기 위한)
```java
        visit[x][y] = true;  // 현재 좌표를 방문한 것으로 표시
        result++;  // 현재 그림의 크기 증가

//이후 평범한 dfs...반복 
```


## :black_nib: **Review**
- result값의 초기화 위치를 순각 착각하여 헤맸다. 

## 📡**Link**
- https://www.acmicpc.net/problem/1926 
