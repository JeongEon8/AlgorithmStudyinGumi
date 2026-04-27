# [백준 - G4] 16234. 인구 이동

## ⏰ **time**

60분

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

1. 아직 방문하지 않은 나라라면 방문(`BFS`)하고, 인구 수가 `L`이상 `R`이하인 인접 나라의 좌표를 `union` 리스트에 넣는다.
2. 리스트에 좌표가 2이상이면 인접한 나라가 1개 이상이므로, 인구 이동을 시작한다. 그리고 인구 이동 여부(`moved`)를 `true`로 변경한다.
3. 단, 각 연합은 하루에 한 번만 처리한다.

```java
while (true) {

    visited = new boolean[N][N];
    boolean moved = false;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!visited[i][j]) {
                List<int[]> union = isOpen(i, j);

                if (union.size() >= 2) {

                    moved = true;
                    int cnt = 0, population = 0;
                    cnt = union.size();
                    for (int[] curr : union) {
                        population += map[curr[0]][curr[1]];
                    }

                    for (int[] curr : union) {
                        map[curr[0]][curr[1]] = population / cnt;
                    }
                }

            }
        }
    }

    if (!moved) {
        break;
    }
    ans++;
}
```

## :black_nib: Review

## 📡**Link**

- <https://www.acmicpc.net/problem/16234>
