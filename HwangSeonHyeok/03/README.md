# [백준 - s1] 15993. 1, 2, 3 더하기 8

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- DP

## :round_pushpin: **Logic**

홀일때 짝일때 경우를 나눈 dp를 사용한다.

```cpp
   int[][] dp = new int[100001][2];//0은 짝 1은 홀
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][0] = 1;
		dp[3][1] = 2;
		dp[3][0] = 2;

		for(int i = 4; i<=100000;i++) {
			dp[i][0] = ((dp[i-1][1]+dp[i-2][1])%mod+dp[i-3][1])%mod;
			dp[i][1] = ((dp[i-1][0]+dp[i-2][0])%mod+dp[i-3][0])%mod;
		}

```

## :black_nib: **Review**

테스트 케이스가 많을 수 있어 한번에 다 계산하고 기록해둔 답을 사용해야 했는데 위 dp계산을 for문에다 적어 시간초과가 났었다.

## 📡**Link**

- https://www.acmicpc.net/problem/15993
