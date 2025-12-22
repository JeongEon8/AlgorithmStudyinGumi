# [백준 - 골드 4] 2573. 빙산
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 배열 전체를 탐색하여 빙산을 녹인다.
2. dfs 탐색을 하여 섬이 몇개 있는지 센다.
   
```java
    while (true) {
            int lend = 0; // 빙산 덩어리 수
            visited = new boolean[N][M];

            // 빙산 덩어리 수 계산
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] > 0 && !visited[x][y]) {
                        dfs(x, y);
                        lend++;
                    }
                }
            }

            if (lend >= 2) { // 두 덩어리 이상으로 분리된 경우
                System.out.println(year);
                break;
            } else if (lend == 0) { // 빙산이 모두 녹은 경우
                System.out.println(0);
                break;
            }

            melt(); // 빙산 녹이기
            year++;
        }
```

## :black_nib: **Review**
- 와 이제는 dfs도 까먹어서 한참 생각했어요

## 📡 Link
https://www.acmicpc.net/problem/2573
