# [백준 - 골드 5] 2240. 자두 나무

## ⏰**time**
48분

## :pushpin: **Algorithm**
- DP

## ⏲️**Time Complexity**
$O(W x T)$

## :round_pushpin: **Logic**
1. 매초마다 이동거리(w) 담을수 있는 배열 생성
2. 초기 세팅 : 1초에 해당 나무가 1이면 ( 1:1, 2:0 ) 2 이이면 (1:0 , 2:1)
3. 2초부터 ~ 자두가 떨어지는 나무가 1이면 홀수 칸에 +1, 2이면 짝수칸에 +1해주는데
    - 이전 값이랑 비교해서 그대로오는게 많은지 이전값에서 이동해서 오는게 많은지 비교하여 변경해준다.
``` java
for(int t = 0; t<T; t++) {
			int tree = Integer.parseInt(in.readLine());
			if(t==0) {
				if (tree == 1) {
                    dp[0][0] = 1;
                    if (W > 0) dp[0][1] = 0; 
                } else {
                    dp[0][0] = 0;
                    if (W > 0) dp[0][1] = 1; 
                }
			}else {
				for(int i = 0; i<=W; i++) {
					
					int type = (i % 2 == 0) ? 1 : 2;
					
					int max = dp[t-1][i];
					
					if(i>0 && dp[t-1][i-1]>max) {
						max= dp[t-1][i-1];
					}
					
					dp[t][i] = max;
					if(type == tree) {
						dp[t][i] += 1;
					}
				}
			}
			
		}
```


## :black_nib: **Review**
- dp는 오랜만에 풀어서 감을 잃어 풀기가 어려웠어요

## 📡 Link
https://www.acmicpc.net/problem/2240
