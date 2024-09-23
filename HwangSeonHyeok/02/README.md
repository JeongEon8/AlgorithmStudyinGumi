# [백준 - g1] 9328. 열쇠

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 구현
- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## :round_pushpin: **Logic**

이 문제는 외벽에서 출입이 가능하므로 배열 크기를 가로, 세로를 2씩 더주고 태두리를 빈 공간으로 설정해서 그래프 탐색시 출입이 가능하게 했다. bfs를 하다가 지금 가지고 있지 않은 열쇠를 얻으면 Set에 해당 열쇠를 추가하고 방문기록, 큐를 초기화하고 해당 위치부터 다시 bfs를 한다. 이런식으로 열쇠를 먹을 때 진행상태가 초기화되므로 문서를 중복해서 챙기지 않기 위해 문서 칸을 탐색 할 때 훔친 문서 개수를 증가시키고 문서를 빈 공간으로 비워줘야한다.

```java
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i == 0 || j == 0 || i == h + 1 || j == w + 1) {

                    building[i][j] = '.';

                }
            }
        }
        int ans = 0;
        boolean[][] visited = new boolean[H][W];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = p.y + dy[i];
                int nextX = p.x + dx[i];
                if (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W && building[nextY][nextX] != '*'
                        && !visited[nextY][nextX]) {
                    char next = building[nextY][nextX];
                    if (next >= 'a' && next <= 'z') {
                        if (!hasKey[next - 'a']) {
                            hasKey[next - 'a'] = true;
                            visited = new boolean[H][W];
                            q.clear();
                        }
                        visited[nextY][nextX] = true;
                        q.add(new Point(nextY, nextX));
                    } else if (next >= 'A' && next <= 'Z') {
                        visited[nextY][nextX] = true;
                        if (hasKey[next - 'A']) {
                            q.add(new Point(nextY, nextX));
                        }
                    } else if (next == '$') {
                        ans++;
                        visited[nextY][nextX] = true;
                        building[nextY][nextX] = '.';
                        q.add(new Point(nextY, nextX));
                    }else {
                        visited[nextY][nextX] = true;
                        q.add(new Point(nextY, nextX));
                    }
                }
            }
        }
```

## :black_nib: **Review**

BOJ 1194.달이 차오른다 가자와 비슷해 보이지만 이 문제에선 열쇠의 종류가 26가지라 bitmask나 visit상태를 기록하기엔 다소 수가 많다. 또한 탐색의 이동 거리는 문제와 중요하지 않고 특정 점들에 도달할 수 있는지가 중요한 문제이므로 열쇠를 새로 챙길때마다 큐와 visit상태를 초기화하는 식으로도 풀 수 있는 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/9328
