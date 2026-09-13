# [PGS - LV2] 154538. 숫자 변환하기

## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- dp

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
dp로 n보다 작은것, /2, /3에서 올수있는지 판단하고 최소 경로를 찾는다.
```java
dp[x] = 1;
for(int i = x; i<=y; i++){
	if(i>n&&dp[i-n]>0){
		dp[i] = dp[i-n]+1;
	}
	if(i%2==0&&dp[i/2]>0){
		dp[i] = dp[i]==0? dp[i/2]+1:Math.min(dp[i],dp[i/2]+1);
	}
	if(i%3==0&&dp[i/3]>0){
		dp[i] = dp[i]==0? dp[i/3]+1:Math.min(dp[i],dp[i/3]+1);
	}
}
if(dp[y]>0)answer= dp[y]-1;
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/76502