# [PGS - LV3] 01\_거스름돈

## ⏰**time**

30분

## :pushpin: **Algorithm**

DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. dp[i]를 i원을 거슬러 줄 수 있는 방법의 수로 정의합니다.
2. 금액 $0$원을 만드는 방법은 "아무 화폐도 쓰지 않는 경우" $1$가지이므로 `dp[0] = 1`로 초기화
3. `dp[i] = (dp[i] + dp[i - coin]) % 1,000,000,007` 점화식을 적용하여 경우의 수를 누적해 갱신

```java
class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1,000,000,007;
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        return dp[n];
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12907?language=java>
