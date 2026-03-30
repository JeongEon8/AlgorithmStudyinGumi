# [백준 - G3] 20058. 마법사 상어와 파이어스톰

## ⏰**time**

120분

## :pushpin: **Algorithm**

구현, BFS

## :round_pushpin: **Logic**

- 블록단위 회전과 얼음 감소를 진행한 후, 최대 덩어리 크기와 얼음 합을 계산하면 끝!

1. $2^N × 2^N$ 블록 단위 회전

- 전체 맵을 $2^L$ 크기로 나눈 뒤 각 블록을 시계 방향 90도 회전
- 새로운 배열에 결과를 저장 후 map 갱신

```java
static void splitMap(int level) {

    int step = 1 << level;
    int[][] newMap = new int[size][size];

    for (int i = 0; i < size; i += step) {
        for (int j = 0; j < size; j += step) {

            for (int x = 0; x < step; x++) {
                for (int y = 0; y < step; y++) {
                    // (x, y) → (y, step-1-x)
                    newMap[i + y][j + step - 1 - x] = map[i + x][j + y];
                }
            }
        }
    }

    map = newMap;
}
```

1. 얼음 감소

- 각 칸에서 상하좌우 인접한 얼음 개수 확인
- 3개 미만이면 해당 칸의 얼음 `-1`

```java
static void melt() {

    int[][] temp = new int[size][size];

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {

            int cnt = 0;

            for (int d = 0; d < 4; d++) {
                int nx = i + dx[d];
                int ny = j + dy[d];

                if (nx < 0 || ny < 0 || nx >= size || ny >= size)
                    continue;

                if (map[nx][ny] > 0)
                    cnt++;
            }

            if (map[i][j] > 0 && cnt < 3) {
                temp[i][j] = map[i][j] - 1;
            } else {
                temp[i][j] = map[i][j];
            }
        }
    }

    map = temp;
}
```

## :black_nib: **Review**

상어 니가 먼데

## 📡 Link

<https://www.acmicpc.net/problem/20058>
