# [백준- G5] 9251. LCS
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 같은 문자가 있는 경우 - `char1[i] == char2[j]`
  - `dp[i][j] = dp[i-1][j-1] + 1` (윗 대각선 값 + 1)
- 다른 문자인 경우 - `char1[i] != char2[j]`
  - `dp[i][j] = Max(dp[i-1][j], dp[i][j-1])` (왼쪽 or 위에 값 중 큰 값으로 갱신)
```java
for (int i = 1; i <= N; i++) {
    for (int j = 1; j <= M; j++) {
        if (char1[i - 1] == char2[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
    }
}
```

## :black_nib: **Review**
이해하기 어려웠다.. 그리고 문자열 길이가 같다는 조건은 없었음. 맘대로 해석하지 말자

## 📡**Link**
- https://www.acmicpc.net/problem/9251
