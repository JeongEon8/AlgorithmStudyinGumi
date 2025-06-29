# [백준 - S1] 2156. 포도주 시식

## ⏰  **time**
25분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 12-3으로 마실래 1-23으로 마실래를 정하는 거다!
2. 둘 중에 더 큰걸 DP에 저장한당!
```cpp
    dp[0] = 0;
    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];

    for (int i = 3; i <= n; i++) {
        dp[i] = max({ dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i], dp[i - 1] });
    }
```

## :black_nib: **Review**
- DP는 너무 어렵다...
- 왜 이런 수학적인 문제가 나올까..
- 수학 싫어잉

## 📡 Link
https://www.acmicpc.net/problem/2156
