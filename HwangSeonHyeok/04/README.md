# [백준 - g3] 26607. 시로코와 은행털기

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍
- 배낭 문제

## :round_pushpin: **Logic**

모든 힘의 합*스피드의 합이 최대가 되는 것을 찾는 문제이다.  
각각의 힘과 스피드의 합은 x로 같으므로 힘의 합만 기록해 둬도 스피드의 합은 (k*x-힘의합)으로 구할 수 있다.  
dp[고른 명수][지금까지 고른 인원의 힘]으로 고른 명수로 해당 힘의 합을 만들 수 있는지를 채크했다.  
for문을 돌면서 dp[i-1]에 현제 index인 사람이 들어 있을 수 있으므로 방문한적이 없는곳을 방문하면 index값을 dp에 넣어주고 이 경우를 제외해준다.

```java
  dp[0][0] = 0;
		for (int idx = 1; idx <= n; idx++) {
			int p = pow[idx];
			int imax = idx<k ? idx:k;
			for (int i = 1; i <= imax; i++) {
				for (int j = 0; j <= max; j++) {
					if (j >= p && dp[i - 1][j - p]!=-1&&dp[i - 1][j - p]!=idx) {
						if(dp[i][j]==-1) {//지금 보니까 이거 위에 if문에 포함시켜도 될 것 같다.
							dp[i][j]=idx;
						}
					}
				}
			}
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i <= max; i++) {
			if (dp[k][i]>0) {
				int sum = i * (max - i);
				if (sum > ans) {
					ans = sum;
				}
			}
		}

```

## :black_nib: **Review**

힘만 기록하거나 방문을 체크하는 발상이 다른 dp문제와 달라 어려웠던 문제다.

## 📡**Link**

https://www.acmicpc.net/problem/26607
