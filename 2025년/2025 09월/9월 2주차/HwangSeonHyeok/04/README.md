# [백준 - S1] 33677. 푸앙이와 콩나무

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
dp[길이][일수,물의양]인 배열을 만들어서 콩나무가 성장한 3가지 경우가 가능한 길이일때 최소의 일수, 최소의 일수 중 최소의 물의 양이 되는 값들을 기록한다.
```java
if (n > 0) {
    dp[1][0] = 1;
    dp[1][1] = 1;
    for (int i = 2; i <= n; i++) {
        int minDay = dp[i - 1][0] + 1;
        int minWater = dp[i - 1][1] + 1;
        if (i % 3 == 0 && minDay >= dp[i / 3][0] + 1) {
            if (minDay == dp[i / 3][0] + 1) {
                minWater = Math.min(minWater, dp[i / 3][1] + 3);
            } else {
                minDay = dp[i / 3][0] + 1;
                minWater = dp[i / 3][1] + 3;
            }
        }
        int sqrt = (int) Math.sqrt(i);
        if (sqrt * sqrt == i && minDay >= dp[sqrt][0] + 1) {
            if (minDay == dp[sqrt][0] + 1) {
                minWater = Math.min(minWater, dp[sqrt][1] + 5);
            } else {
                minDay = dp[sqrt][0] + 1;
                minWater = dp[sqrt][1] + 5;
            }
        }
        dp[i][0] = minDay;
        dp[i][1] = minWater;
    }
}
```  
## :black_nib: **Review** 
알고리즘 분류보니까 너비 우선 탐색이 있는데 어떻게 풀지..?
## 📡**Link**
https://www.acmicpc.net/problem/33677