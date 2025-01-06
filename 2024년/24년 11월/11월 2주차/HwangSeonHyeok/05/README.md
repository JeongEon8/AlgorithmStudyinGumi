# [백준 - G4] 2758. 로또

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**

dp에 n개를 고르고 최대 m의 수까지 고르는 경우를 구해준다. 각각 n번째 고를 수 있는 수는 최소 $2^{n-1}$부터 계산해주면 된다.

```java
	long[][] dp = new long[11][2001];
	for (int i = 1; i <= 2000; i++) {
		dp[1][i] = i;

	}
	for (int i = 2; i <= 10; i++) {
		for (int j = (int) Math.pow(2, i - 1); j <= 2000; j++) {
			dp[i][j] += dp[i - 1][j / 2] + dp[i][j - 1];

		}
	}

	for (int i = 0; i < t; i++) {
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		System.out.println(dp[n][m]);

	}
```

## :black_nib: **Review**

처음엔 각각의 숫자로 끝나는 경우만 세고 누적시키지 않고 각 TC마다 for문으로 $2^{n-1}$부터 m까지 dp[n][i]를 더해주는 식으로 풀었으나 어차피 TC가 반복돼서 누적시키는 형식으로 수정하였다.

## 📡**Link**

https://www.acmicpc.net/problem/2758
