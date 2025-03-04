# [백준 - G5] 3055. 탈출


## ⏰ **time**
50분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
O(N)

## :round_pushpin: **Logic**

1. 지도에서 물이 있는 위치를 water 큐에 저장한다.
2. queue에 있는 물의 위치를 이용해 고슴도치가 비버의 굴까지 갈 수 있는지 여부를 bfs를 이용해 탐색한다.

```java
for (int i = 0; i < R; i++) {
    String s = br.readLine();
    for (int j = 0; j < C; j++) {
        map[i][j] = s.charAt(j);
        if (map[i][j] == 'S') { // 고슴도치 위치
            Sx = i;
            Sy = j;
        }
        if (map[i][j] == '*') { // 물이 차 있는 곳 좌표
            water.offer(new int[] { i, j });
        }
    }
}

result = false;
min = Integer.MAX_VALUE;

bfs(Sx, Sy);
```


## :black_nib: **Review**
알고리즘 재미있게 푸는 법이 알고 싶어요..

## 📡**Link**
https://www.acmicpc.net/problem/3055
