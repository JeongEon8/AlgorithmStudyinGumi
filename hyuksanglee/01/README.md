# [백준 - 골드 5] 17836. 공주님을 구해라

## ⏰**time**

60분

## :pushpin: **Algorithm**

BFS

## ⏲️**Time Complexity**

$O(N × M)$

## :round_pushpin: **Logic**

1. 검 보유 여부에 따라 다른 상태를 가지므로 3차원 `visited`를 활용해야한다! => 이거 판단 아직 어려운 듯
2. 검을 만났을 경우: 상태를 1로 변경. 이때 현재 상태는 유지하고 다음 상태를 1로 해야한다.
3. 아직 방문하지 않았을 때
   - 벽일 경우 반드시 검을 보유해야 통과 가능
   - 시간 `T`를 초과하지 않을 것

```java
static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int rescue(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];
            int hasGram = curr[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[x][y][hasGram] > T) {
                    continue;
                }

                if (nx == N - 1 && ny == M - 1) {
                    visited[nx][ny][hasGram] = visited[x][y][hasGram] + 1;
                    return visited[nx][ny][hasGram] - 1;
                }

                int nextGram = hasGram;
                if (map[nx][ny] == 2) { // 검 획득
                    nextGram = 1;
                }

                if (visited[nx][ny][nextGram] == 0) {
                    // 벽인데, 검이 없을 경우
                    if (map[nx][ny] == 1 && nextGram == 0) {
                        continue;
                    }

                    visited[nx][ny][nextGram] = visited[x][y][hasGram] + 1;
                    queue.offer(new int[]{nx, ny, nextGram});

                }
            }

        }

        return -1;
    }
```

## :black_nib: **Review**

- 내가 공주님을 구함..!! 대박슨
- `hasGram`이랑 `nextGram`이랑 너무 헷갈려..!
- `hasGram`을 1로 바로 변경해버리면 밑의 연산들이 모두 1로 계산되기 때문에 `nextGram`을 활용

## 📡 Link

<https://www.acmicpc.net/problem/17836>
