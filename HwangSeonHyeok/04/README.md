# [백준 - G2] 2169. 로봇 조종하기

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(MN)$

## :round_pushpin: **Logic**
좌상단에서 좌, 하, 우 3방향으로 이동하여 우하단에 도착했을때 최대 값을 만드는 문제.  
다른 문제들은 보통 우, 하 2방향으로만 이동하는데 좌이동이 추가되어 우, 하방향 한 줄을 해결할때마다 왼쪽 이동하는 경우들도 계산해줘야한다.  
최댓값 갱신하는데만 사용하므로 왼쪽으로 계산하는 경우는 int에만 기록하고 바로 dp에 최대값을 갱신하는 방법을 사용하였다.

```java
static void solve(){
	dp[1][1] = mars[1][1];
	for(int i = 1; i<=n;i++){
		for(int j = 1;j<=m;j++){
			dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j]+mars[i][j],dp[i][j-1]+mars[i][j]));
		}
		if(i==1||i==n) continue;
		int lineDP = dp[i-1][m]+mars[i][m];
		for(int j=m-1;j>=1;j--){
			lineDP = Math.max(dp[i-1][j]+mars[i][j],lineDP+mars[i][j]);
			if(dp[i][j]<lineDP){
				dp[i][j] = lineDP;
			}
		}

	}
}
```

## :black_nib: **Review**
왼쪽 이동경우에서 오타가 있어서 디버깅하는데 시간이 오래걸렸다..
## 📡**Link**

https://www.acmicpc.net/problem/2169
