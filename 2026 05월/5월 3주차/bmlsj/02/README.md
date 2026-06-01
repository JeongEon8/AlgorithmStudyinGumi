# [PGS - Lv2] 02\_미로 탈출

## ⏰**time**

30min

## :pushpin: **Algorithm**

BFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. BFS로 최단거리 구하기
2. 레버의 상태도 고려해야하므로 3차원 visited 사용
3. 레버를 가진 후 탈출할 수 있다.

```java
static int start(int x, int y, char[][] map) {

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        queue.offer(new Node(x, y, 0, false));
        visited[x][y][0] = true;

        while(!queue.isEmpty()) {

            Node curr = queue.poll();


            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                boolean nextLever = curr.lever;

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;

                if (map[nx][ny] == 'L') {
                    nextLever = true;
                }

                if (nextLever && map[nx][ny] == 'E') {
                    return curr.dist + 1;
                }

                int state = nextLever ? 1 : 0;
                if (!visited[nx][ny][state] && map[nx][ny] != 'X') {
                    visited[nx][ny][state] = true;
                    queue.offer(new Node(nx, ny, curr.dist + 1, nextLever));
                }
            }

        }

        return -1;
    }
```

## :black_nib: **Review**

레버의 상태를 for문 안에서 체크해주기.. 각 방향마다 상태 체크를 위해

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/159993>
