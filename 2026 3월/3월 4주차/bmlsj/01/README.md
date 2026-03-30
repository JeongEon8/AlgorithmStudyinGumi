# [백준 - G3] 20057. 마법사 상어와 토네이도

## ⏰**time**

60분

## :pushpin: **Algorithm**

구현

## :round_pushpin: **Logic**

1. 격자의 중심인 `(r/2, c/2)` 좌표부터 `(좌, 하, 우, 상)` 반시계 방향으로 회전한다.
   - 길이가 1인 회전을 2번하면 길이가 2인 회전을 2번하게 된다.
2. 회전을 하면 모래가 흩날려야 하는데, 아래의 회전공식을 통해 비율에 맞게 흩날릴 수 있게 한다.
3. 남은 모래값은 `a`에 넣고, 범위를 벗어나는 모래들의 합이 정답이므로 `answer`에 모두 더한다.

[회전 공식]

| 회전  | 공식                      |
| ----- | ------------------------- |
| 90도  | `(dx, dy)` → `(-dy, dx)`  |
| 180도 | `(dx, dy)` → `(-dx, -dy)` |
| 270도 | `(dx, dy)` → `(dy, -dx)`  |

1. 달팽이 마냥 뱅글뱅글 돌리기

```java
static int[] dx = { 0, 1, 0, -1 };
static int[] dy = { -1, 0, 1, 0 };

static void move(int x, int y) {

    boolean[][] visited = new boolean[n][n];
    visited[x][y] = true;

    int dir = 0;
    int len = 1;
    while (true) {

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < len; j++) {
            x += dx[dir];
            y += dy[dir];

            // 토네이도 진행(모래 퍼트리기)
            storm(x, y, dir);

            if (x == 0 && y == 0)
                return;
            }

            dir = (dir + 1) % 4;
        }
        len++;
    }
}
```

1. 비율별로 모래 퍼트리기

```java
static void storm(int x, int y, int dir) {

  // 비율 별로 모래가 흩날린다
    int sand = map[x][y];
    int totalMoved = 0;

    for (Spread spread : ratio) {

        int nx = 0, ny = 0;

        switch (dir) {
            case 0: {
                nx = x + spread.dx;
                ny = y + spread.dy;
                break;
            }
            case 1: {
                nx = x - spread.dy;
                ny = y + spread.dx;
                break;
            }

            case 2: {
                nx = x - spread.dx;
                ny = y - spread.dy;
                break;
            }
            case 3: {
                nx = x + spread.dy;
                ny = y - spread.dx;
                break;
            }
        }

        int moved = (int) (sand * spread.percent / 100);
        totalMoved += moved;

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            answer += moved;
        } else {
            map[nx][ny] += moved;
        }
    }

    int ax = x + dx[dir];
    int ay = y + dy[dir];
    int alpha = sand - totalMoved;

    if (ax < 0 || ay < 0 || ax >= n || ay >= n) {
        answer += alpha;
    } else {
        map[ax][ay] += alpha;
    }
}
```

## 📡 Link

<https://www.acmicpc.net/problem/20057>
