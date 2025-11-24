# [프로그래머스 - S3]2579. 계단 오르기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
- dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 2차원 배열 만들어서 1번째 칸에는 2번 밑에 있는 계단에서 가장 큰값 불러와서 현제 값이랑 더해서 넣어주고
2. 2번째 칸에는 1번 밑에 있는 1번째 값이랑 더해서 넣어준다.
```java
for(int i = 0; i<n; i++) {
			int max = 0;
			int p = Integer.parseInt(in.readLine());
			if(i == 0) {
				dp[i][0] = p;
				dp[i][1] = p;
			}
			else if(i==1) {
				dp[i][0] = p;
				dp[i][1] = p+dp[0][0];
			}
			else {
				if(max < dp[i-2][0]) {
					max = dp[i-2][0];
				}
				if(max < dp[i-2][1]) {
					max = dp[i-2][1];
				}
				dp[i][0] = max + p;
				dp[i][1] = dp[i-1][0] + p;
			}
				
			
		}
		
		int max = 0;
		if(dp[n-1][0]>max) {
			max=dp[n-1][0];
		}
		if(dp[n-1][1]>max) {
			max = dp[n-1][1];
		}
```



## :black_nib: **Review**
- 잠이 안와서 한문제 풀었어요

## 📡**Link**
- https://www.acmicpc.net/problem/2579
