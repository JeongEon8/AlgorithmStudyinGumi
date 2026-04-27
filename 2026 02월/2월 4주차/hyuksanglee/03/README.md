# [백준 - 실버 3] 14501. 퇴사

## ⏰**time**
20분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 일을 만료한 이후 금액을 비교했을때 더 클경우 변경해준다.
```
for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			int T = Integer.parseInt(input[0]);
			int P = Integer.parseInt(input[1]);
			
			if(T+n<=N  && dp[T+n] < dp[n]+P) {
				dp[T+n] = dp[n]+P;
				if(result< dp[T+n]) {
					result = dp[T+n];
				}
			}
			
			for(int m = T+n+1; m<=N; m++) {
				if(dp[m] < dp[n]+P) {
					dp[m]= dp[n]+P;
				}
				if(result< dp[T+n]) {
					result = dp[T+n];
				}
			}
			
			
		}
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/14501](https://www.acmicpc.net/problem/14501)
