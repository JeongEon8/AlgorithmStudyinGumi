# [백준 - s2] 13565. 침투

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 깊이 우선 탐색

## :round_pushpin: **Logic**

map[0][i]를 돌면서 0인곳이 있으면 dfs로 들어가고 map[m-1] 중 한곳이라도 들어가면 YES이다.

```java
   static void dfs(int curY, int curX) {

        visited[curY][curX] = true;

        if (curY == m - 1) {
            ans = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < m && nextX < n && !visited[nextY][nextX]
                    && map[nextY][nextX] == 0) {

                dfs(nextY, nextX);
                if (ans)
                    return;
            }
        }
    }

```

## 📡**Link**

https://www.acmicpc.net/problem/13565
