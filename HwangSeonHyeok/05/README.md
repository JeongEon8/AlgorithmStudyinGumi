# [백준 - G5] 17953. 디저트

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM^2)$

## :round_pushpin: **Logic**
DP로 이전과 같은 것을 먹고오는경우는 현제 만족도를 반으로 하는 식으로 계산해서 각각의 날까지 어떤걸 먹고 최대 만족도가 됐는지 기록하면서 계산한다.
```java
for(int i = 1;i<n;i++){
	for(int j = 0;j<m;j++){
		for(int k = 0; k<m;k++){
			if(j==k){
				dp[i][j] = Math.max(dp[i-1][k]+(arr[j][i]/2),dp[i][j]);
			}else {
				dp[i][j] = Math.max(dp[i-1][k]+arr[j][i],dp[i][j]);
			}
		}
	}
}
int ans = 0;
for(int i = 0; i<m;i++){
	ans = Math.max(ans,dp[n-1][i]);
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/17953
