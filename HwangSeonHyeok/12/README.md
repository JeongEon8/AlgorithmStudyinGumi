# [백준 - g2] 16946. 벽 부수고 이동하기 4

## ⏰ **time**

120분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 깊이 우선 탐색

## :round_pushpin: **Logic**

0들을 bfs로 돌려서 각 구역의 크기를 미리 구해두고 각각의 벽마다 사방의 이동할 수 있는 구역의 크기의 합을 계산하였다.

```java
		for (Point w : wList) {
            Set<Integer> adjacentSpaces = new HashSet<>();
            int cnt = 1;
            for (int i = 0; i < 4; i++) {
                int nexty = w.y + dy[i];
                int nextx = w.x + dx[i];
                if (nexty >= 0 && nextx >= 0 && nexty < n && nextx < m && graph[nexty][nextx] == 0) {
                    int spaceIndex = graph2[nexty][nextx];
                    if (adjacentSpaces.add(spaceIndex)) {
                        cnt += spaceList.get(spaceIndex);
                    }
                }
            }
            graph[w.y][w.x] = cnt % 10;
        }
```

## :black_nib: **Review**

ArrayIndexOutOfBounds오류가 계속났으나 1시간넘게 원인을 찾지못했다.  
오타도 아니고 범위체크는 if문마다 가장 먼저 넣어주었는데..  
오류가 날 수 있는 부분의 boolean 체크 배열을 Set으로 바꾸고 List에 빈값을 넣어 index를 통일시켜서 가능하면 범위 밖으로 나갈 변수를 줄였더니 통과됐다.

## 📡**Link**

https://www.acmicpc.net/problem/16946
