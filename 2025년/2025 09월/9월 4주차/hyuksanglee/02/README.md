# [백준- G4] 16398. 행성연결
 
## ⏰  **time**
80분

## :pushpin: **Algorithm**
그래프

## ⏲️**Time Complexity**
$O(N²)$
- N: 가로 길이, M: 세로 길이
## :round_pushpin: **Logic**
- for문으로 시작점을 하나씩 다 돌아본다
- 방문하지 않은 행성 중에서 현재까지 연결되는 비용이 가장 작은 행성을 선택
- N번 반복하여 모든 행성을 연결
- 새로 선택한 행성과 다른 행성 값 비교하여 작은값으로 갱신
- 각 행성에 기록된 최소 연결 비용합 출력
```java
   static void pl(int num) {
		int u = -1;
        int best = Integer.MAX_VALUE;
        
        for (int v = 0; v < N; v++) {
            if (!isVisited[v] && de[v] < best) {
                best = arr[num][v];
                u = v;
            }
        }
        
        isVisited[u] = true;
        for (int v = 0; v < N; v++) {
            if (!isVisited[v] && arr[u][v] < de[v]) {
                de[v] = arr[u][v];
            }
        }
	}
```

## :black_nib: **Review**
어려워요

## 📡**Link**
- https://www.acmicpc.net/problem/16398
