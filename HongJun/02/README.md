# [백준 - G5] 9251. LCS

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
```python
for i in range(1, l1 + 1):
    for j in range(1, l2 + 1):
        # 같은 알파벳일 때 +1
        if s1[i - 1] == s2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1

        # 다른 경우, 이전의 값에서 최댓값
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/9251