# [백준 - G4] 17404. RGB거리 2

## ⏰  **time**
42분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 현재 선택한 색깔을 제외하고 이전 다른 색들중 작은수를 더해서 현재 색상칸에 넣어준다.
2. 마지막 값은 첫번째 값이랑 달라야하므로 3번 반복해서 첫번쨰 값을 하나로 고정해서 계산해준다.
```java
        for(int start = 0; start<3; start++) {
			int[][] dp = new int[N][3];
			for(int n=0; n<N; n++) {
				if(n ==0) {
					for(int j =0; j<3; j++) {
						if(j==start) {
							dp[n][j] = cost[n][j];
						}else {
							
							dp[n][j] = Integer.MAX_VALUE;
						}
						
					}
					
				}else {
					for(int i =0; i<3; i++) {
						int max = Integer.MAX_VALUE;
						for(int j = 0; j<3; j++) {
							if(j != i) {
								if(max>dp[n-1][j]) {
									max = dp[n-1][j];
								}
								
							}
						}
						if(max == Integer.MAX_VALUE) {
							dp[n][i] = max;
						}else {
							dp[n][i] = cost[n][i] + max;
						}
						
					}
					
				}
				
			}
			
			for(int i =0; i<3; i++) {
				if(i != start) {
					if(result>dp[N-1][i]) {
						result = dp[N-1][i];
					}
				}
	
			}
			
		}
```


## :black_nib: **Review**
- dp도 어려워죽겠는데 원형 고리라 더 어려웠음

## 📡**Link**
- https://www.acmicpc.net/problem/17404
