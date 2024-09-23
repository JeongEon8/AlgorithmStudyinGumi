# [백준] 5582. 공통 부분 문자열 

## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
				if (a.charAt(i - 1) == b.charAt(j - 1)) { // 두 문자가 같으면
					dp[i][j] = dp[i - 1][j - 1] + 1; // 이전의 공통 부분 문자열 길이에 1을 더한다.
					if (dp[i][j] > result)
						result = dp[i][j]; 
				} else { // 공통부분 없으면 0으로 초기화 
					dp[i][j] = 0;
				}
```

## :black_nib: **Review**
- 나는 DP가 싫어요! 익숙하지 않아서 버벅거리는 문제 

## 📡**Link**
- https://www.acmicpc.net/problem/5582
