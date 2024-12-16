# [백준 - S1] 28422. XOR 카드 게임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
2장가져가는 경우와 3장가져가는 경우를 XOR연산과 bitCount를 이용해 점수를 계산해서 최대인 경우를 dp로 구한다.  
계산과정에서 1~4번째 카드를 뽑는 상황에서의 불가능한 경우 예외처리와 마지막 카드 한장이 남는경우 0점 처리만 예외처리해줬다.

```java
	dp[0] = 0;
	dp[1] = 0;
	for(int i = 2; i<=n;i++) {
		if(i==n-1) {
			dp[n-1] = 0;
			continue;
		}
		if(i!=3) {
			dp[i] = Integer.max(dp[i],dp[i-2]+Integer.bitCount(cards[i-1]^cards[i-2]));
		}
		if(i!=2&&i!=4) {
			dp[i] = Integer.max(dp[i],dp[i-3]+Integer.bitCount(cards[i-1]^cards[i-2]^cards[i-3]));
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/28422
