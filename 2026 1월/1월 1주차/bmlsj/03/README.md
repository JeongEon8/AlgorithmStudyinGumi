# [백준 - G3] 16235. 나무 재태크

## ⏰  **time**

60분

## ⏲️**Time Complexity**

$O(K×N^2×TlogT)$

## :round_pushpin: **Logic**

- 봄, 여름, 가을, 겨울의 로직대로 구현
- 중요한 점은 한 칸에 나무가 여러 개 심어질 수가 있다.
  때문에 `List<>[][]`을 사용해 `tree[i][j].add(1)`로 새 나무를 추가하여야 한다.
- 나이가 어린 나무부터 양분을 먹게 하기 위해 나무들을 정렬해 진행한다.

1. 봄, 여름

```java
static void spring(int N) {

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {

        Collections.sort(trees[i][j]);
        List<Integer> alive = new ArrayList<>();
        int dead = 0;
        for (int age : trees[i][j]) {
            if (nutrients[i][j] >= age) {
                nutrients[i][j] -= age;
                alive.add(age + 1);
            } else {
                dead += age / 2;
            }
        }

        trees[i][j] = alive;
        nutrients[i][j] += dead;
    }
  }
}
```

1. 가을

```java
static void fall(int N) {

  int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
  int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

  // 나무가 있고, 나이가 5의 배수
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for (int age : trees[i][j]) {
                if (age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                            continue;
                        trees[nx][ny].add(1);
                    }
                }
            }
        }
    }
}
```

1. 겨울

```java
static void winter(int N) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            nutrients[i][j] += A[i][j];
        }
    }
}
```

## :black_nib: Review

## 📡**Link**

- <https://www.acmicpc.net/problem/16235>
