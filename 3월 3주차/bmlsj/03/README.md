# [백준 - 골드4] 14502. 연구소

## ⏰ **time**

30분

## :pushpin: **Algorithm**

완전탐색 + BFS

## ⏲️**Time Complexity**

$O(\binom{N^2}{3} \times N^2)$

---

## :round_pushpin: **Logic**

1. 빈칸 중 조합으로 3개를 선택하여 벽을 세움
2. 벽을 3개 세운 후, map을 복사한 뒤 BFS로 바이러스를 퍼뜨림
3. 퍼진 결과에서 안전 영역(0)의 개수를 계산
4. 최대값 갱신

- 원본 map을 직접 변경하면 안 됨 복사본 사용

```java
// 1. 벽 3개 조합
static void combinations(List<Pair> walls, int start, int depth) {
    if (depth == 3) {

        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }

        spreadVirus(temp);

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) count++;
            }
        }

        answer = Math.max(answer, count);
        return;
    }

    for (int i = start; i < walls.size(); i++) {
        Pair p = walls.get(i);
        map[p.x][p.y] = 1;
        combinations(walls, i + 1, depth + 1);
        map[p.x][p.y] = 0;
    }
}
```

```java
// 2. BFS로 바이러스 확산
static void spreadVirus(int[][] tmpMap) {

    Queue<Pair> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (tmpMap[i][j] == 2) {
                queue.offer(new Pair(i, j));
            }
        }
    }

    while (!queue.isEmpty()) {
        Pair curr = queue.poll();

        for (int i = 0; i < 4; i++) {
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (tmpMap[nx][ny] == 0) {
                tmpMap[nx][ny] = 2;
                queue.offer(new Pair(nx, ny));
            }
        }
    }
}
```

## :black_nib: **Review**

## 📡**Link**

<https://www.acmicpc.net/problem/14502>
