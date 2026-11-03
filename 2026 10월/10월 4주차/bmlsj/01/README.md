# [PGS - LV3] 01\_등굣길

## ⏰**time**

30분

## :pushpin: **Algorithm**

dp

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**

위에서 아래로 내려오는 경우 + 왼쪽에서 오른쪽으로 이동하는 경우를 더한 값이 정답

1. 가장자리 테두리는 모두 1로 채워진다.
2. 테두리 내부의 행과 열에는 (위쪽 경우의 수 + 왼쪽 경우의 수)를 계속 더해서 채워나간다.

```java
for(int i = 1; i <= n; i++) {
    for(int j = 1; j <= m; j++) {
        if (i == 1 && j == 1) continue;
        if (isCheck[i][j]) {
            dp[i][j] = 0;
            continue;
        }

        long fromTop = (i > 1) ? dp[i-1][j] : 0;
        long fromLeft = (j > 1) ? dp[i][j-1] : 0;

        dp[i][j] = (int) ((fromTop + fromLeft) % mod);
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42898>
