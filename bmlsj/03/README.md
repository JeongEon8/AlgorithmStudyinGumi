# [백준 - G1] 13460. 구슬 탈출2

## ⏰ **time**

60분

## ⏲️**Time Complexity**

$O(N^2*M^2(N + M))$

## :round_pushpin: **Logic**

1. 빨간 구슬과 파란 구슬의 위치로 `bfs` 함수를 실행한다.
2. 한 방향을 선택하면 벽을 만날 때 까지 계속 이동하다, 빨간구슬이 구멍(O) 을 만나면 종료한다.
3. 만약 두 공이 같은 위치에 있다면, 더 많이 이동한 구슬이 한칸 뒤로 이동한다.
   ex) `R . . . B` => `. . . R B` 가 되어야 한다

```java
static void bfs(int x, int y, int bx, int by) {

    visited[x][y][bx][by] = true;
    Queue<State> queue = new ArrayDeque<State>();
    queue.offer(new State(x, y, bx, by, 0));

    while (!queue.isEmpty()) {

        State curr = queue.poll();
        if (curr.depth >= 10) {
            System.out.println("-1");
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[] r = move(curr.rx, curr.ry, i);
            int[] b = move(curr.bx, curr.by, i);

            // 파란공이 빠질 경우
            if (map[b[0]][b[1]] == 'O') {  // 파란공을
                continue;
            }
            // 빨간 공이 빠질 경우
            if (map[r[0]][r[1]] == 'O') {
                System.out.println(curr.depth + 1);
                return;
            }

            if (r[0] == b[0] && r[1] == b[1]) {
                if (r[2] > b[2]) { // 빨간공이 왼쪽에 잇으므로 | 빨 | 파 | 이렇게 위치
                    r[0] -= dx[i];
                    r[1] -= dy[i];
                } else {
                    b[0] -= dx[i];
                    b[1] -= dy[i];
                }
            }

            if (!visited[r[0]][r[1]][b[0]][b[1]]) {
                visited[r[0]][r[1]][b[0]][b[1]] = true;
                queue.offer(new State(r[0], r[1], b[0], b[1], curr.depth + 1));
            }

        }

    }
    System.out.println("-1");

 }
```

## :black_nib: Review

처음에는 파란 구슬이 구멍에 빠지면 return으로 종료하였는데 실패하였다.
파란 구슬이 먼저 들어가더라도 빨간 구슬이 먼저 들어가면 성공이어야 하는데, 내 코드에서는 왼쪽으로 먼저 구르다보니 `-1`이 계속 출력되었다.
`continue` 로 변경해 다른 상황도 고려할 수 있게 변경하였음

## 📡**Link**

- <https://www.acmicpc.net/problem/13460>
