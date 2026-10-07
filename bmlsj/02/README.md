# [PGS - LV2] 02_2 x n 타일링

## ⏰**time**

30분

## :pushpin: **Algorithm**

DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. $2 \times n$ 크기의 직사각형을 채우는 경우의 수는 맨 오른쪽 타일 배치에 따라 구분된다.
   - 세로 타일 1개를 놓는 경우: 남은 공간은 $2 \times (n-1)$ $\rightarrow f(n-1)$가지
   - 가로 타일 2개를 위아래로 놓는 경우: 남은 공간은 $2 \times (n-2)$ $\rightarrow f(n-2)$가지

   따라서 점화식은 피보나치 수열 형태인 $f(n) = f(n-1) + f(n-2)$가 된다.

2. 오버플로우를 방지하기 위해 매 덧셈 연산마다 1,000,000,007로 나눈 나머지를 저장

```java
class Solution {
    public int solution(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }

}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12900>
