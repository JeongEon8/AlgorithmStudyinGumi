# [백준 - G5] 20546. 마법사 상어와 비바라기

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
이동 방향과 대각선 이동 정보들을 배열에 저장해두고 비바라기 과정을 1~5번 순서로 반복한다.
```java
static void rainDance(int direction, int count) {
    int dx = directionX[direction] * count;
    int dy = directionY[direction] * count;
    boolean[][] rainyArea = new boolean[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (cloud[i][j]) {
                int rainX = (j + dx % n + n) % n;
                int rainY = (i + dy % n + n) % n;
                buckets[rainY][rainX]++;
                cloud[i][j] = false;
                rainyArea[rainY][rainX] = true;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (rainyArea[i][j]) {
                for (int k = 0; k < 4; k++) {
                    int nextX = j + crossX[k];
                    int nextY = i + crossY[k];
                    if (inRange(nextY, nextX) && buckets[nextY][nextX] >= 1) {
                        buckets[i][j]++;
                    }
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!rainyArea[i][j] && buckets[i][j] >= 2) {
                buckets[i][j] -= 2;
                cloud[i][j] = true;
            }
        }
    }

}
```
## :black_nib: **Review**
쌩구현문제
## 📡**Link**

https://www.acmicpc.net/problem/21610