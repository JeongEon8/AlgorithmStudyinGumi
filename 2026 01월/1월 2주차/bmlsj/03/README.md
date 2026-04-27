# [백준 - G5] 15686. 치킨 배달

## ⏰  **time**

90분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 치킨집 좌표중 M개의 치킨집 선택하기

치킨 집의 좌표를 List에 넣고 그 중 조합을 활용해 M개의 좌표를 선택한다.
M개가 선택되면, 집 당 가장 최소 거리의 치킨 값을 모두 더한다.
모든 최소 거리의 합 중 가장 작은 값이 정답

```java
static void combi(int cnt, int start, List<int[]> chickens) {

        if (cnt == M) {
            int sum = 0;
            // 집별 모든 치킨 거리(한 집에서 모든 치킨집의 최소)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) { // 집
                        sum += calcDir(chickens, i, j);
                    }
                }
            }
            V = Math.min(sum, V);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!chooseChicken[i]) {
                chooseChicken[i] = true;
                combi(cnt + 1, i + 1, chickens);
                chooseChicken[i] = false;
            }
        }
}
```

2. 집 당 모든 치킨 거리의 최소값 구하기
```java
static int calcDir(List<int[]> chickens, int x, int y) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < chooseChicken.length; i++) {
            if (chooseChicken[i]) {
                int nx = Math.abs(chickens.get(i)[0] - x);
                int ny = Math.abs(chickens.get(i)[1] - y);

                min = Math.min(min, nx + ny);
            }

        }

        return min;
    }
```

## :black_nib: Review

## 📡**Link**

- https://www.acmicpc.net/problem/15686
