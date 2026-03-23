# [백준 - 실버5] 2167. 2차원 배열의 합

## ⏰ **time**

30분

## :pushpin: **Algorithm**

누적합

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

`(i, j)` 부터 `(x, y)`까지의 합 구하기

```java
int sx, sy, ex, ey;
for (int i = 0; i < k; i++) {
    input = br.readLine().split(" ");
    sx = Integer.parseInt(input[0]) - 1;
    sy = Integer.parseInt(input[1]) - 1;
    ex = Integer.parseInt(input[2]) - 1;
    ey = Integer.parseInt(input[3]) - 1;

    calcSum(sx, sy, ex, ey);
}

static void calcSum(int sx, int sy, int ex, int ey) {

    int sum = 0;

    for (int i = sx; i <= ex; i++) {
        for (int j = sy; j <= ey; j++) {
            sum += map[i][j];
        }
    }

    System.out.println(sum);
}
```

## :black_nib: **Review**

## 📡**Link**

<https://www.acmicpc.net/problem/2167>
