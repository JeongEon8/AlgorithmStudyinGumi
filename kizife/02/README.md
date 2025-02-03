# [백준] 9084. 동전


## ⏰ **time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
O(nm)

## :round_pushpin: **Logic**
dp[i]는 i원을 만드는 경우의 수 </br>
dp[0]=1임 </br>
이건 달리 설명할 방법이...
```java
            dp[0] = 1; // 목표 금액이 0일 때는 방법 하나뿐

            for (int coin : coins) {
                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
```

## :black_nib: **Review**
지금까지 이걸 안 풀었다니? 

## 📡**Link**
https://www.acmicpc.net/problem/9084
