# [백준 - S1] 22871. 징검다리 건너기 (large)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
가장오른쪽으로 건너갈때까지 드는힘 K가 최소가 되는 경우이므로 다이나믹 프로그래밍으로 기록하면서 계산한다.

```java
public static long power(int i, int j){
	return (j-i)*(1+Math.abs(stones[i]-stones[j]));
}

for(int i = 2; i<=n;i++){
	for(int j = 1;j<i;j++){
		dp[i] = Math.min(dp[i],Math.max(dp[j],power(j,i)));
	}
}
```

## :black_nib: **Review**
K가 최소가 되는 경우를 기록해야해서 처음 계산할때 햇갈렸다.

## 📡**Link**

https://www.acmicpc.net/problem/22871
