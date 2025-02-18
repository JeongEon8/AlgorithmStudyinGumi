# [백준] 15989. 1, 2, 3 더하기 4


## ⏰ **time**
40분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
dp[n][m]이란 m으로 n을 만들 수 있는 경우의 수이다. </br>
m이 1이면 1만으로 만드는 경우의 수, 2면 1, 2로 만드는 수, 3이면 1, 2, 3을 사용해서 만드는 경우. </br>
초기값을 세팅해 주고 더하는 방식으로 누적해 나가면 된다.
```java
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();

            for (int i = 4; i <= n; i++) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }
```


## :black_nib: **Review**
정답률 64퍼라서 얕봤는디 

## 📡**Link**
https://www.acmicpc.net/problem/15989
