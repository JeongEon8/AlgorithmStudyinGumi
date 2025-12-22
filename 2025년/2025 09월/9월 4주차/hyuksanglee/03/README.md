# [백준- G4] 1956. 운동
 
## ⏰  **time**
90분

## :pushpin: **Algorithm**
플로이드–워셜

## ⏲️**Time Complexity**
$O(V³)$
## :round_pushpin: **Logic**
- A-> B 를 가는 거리를 A->B 랑 A -> ? -> B 이거를 비교하는거라 ? 안에 하나씩 다 넣어서 최소값 을 출력해주면 된다
```java
   for (int k = 1; k <= V; k++) {
		    for (int i = 1; i <= V; i++) {
		        for (int j = 1; j <= V; j++) {
		            if (arr[i][k] != INF && arr[k][j] != INF) {
		                arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
		            }
		        }
		    }
		}

		int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                if (arr[i][j] == INF || arr[j][i] == INF) continue;
                int cycle = arr[i][j] + arr[j][i];
                if (cycle < ans) ans = cycle;
            }
        }
```

## :black_nib: **Review**
플로이드–워셜 이거는 그냥 3중 for문만 쓰면 되서 쉬웠어요

## 📡**Link**
- https://www.acmicpc.net/problem/1956
