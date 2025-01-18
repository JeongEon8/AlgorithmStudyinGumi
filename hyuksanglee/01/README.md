# [백준 - 실버 3] 17626. Four Squares
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. dp[i] = dp[i-1] + 1
2. dp[i] = min(dp[i], dp[i-j*j]+1)로 자기보다 작은 모든 제곱수들을 탐색하면서 min함수로 최소 개수
```cpp
    for(int i=1;i<=n;i++){
        dp[i] = dp[i-1] + 1;
        for(int j=1;j*j<=i;j++){
            dp[i] = min(dp[i],dp[i-j*j]+1);
        }
    }
```

## :black_nib: **Review**
- dp 짱어렵네.. 실버가 골드같았다..

## 📡 Link
https://www.acmicpc.net/problem/17626
