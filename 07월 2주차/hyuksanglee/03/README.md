# [백준 - G3] 11066. 파일 합치기

## ⏰ **time**

120분

## :pushpin: **Algorithm**
- dp

## ⏲️**Time Complexity**

$O(N³)$

## :round_pushpin: **Logic**
1. 점화식 : i부터 j까지 구하려면 중간 k를 만들어서 i~k 부터 k~j 최솟값 끼리 더해주면 된다. 
	- 예를 들어 1부터 4까지 최솟값을 구하려면
		1. 1~1이랑 2~4
     		2. 1~2랑 3~4
          	3. 1~3이랑 4~4
	이렇게 3가지가 있다 그래서 중간값 k를 for 문을 돌면서 최솟값으로 dp를 채우준다
```java
	for (int len = 1; len < K; len++) {
                for (int i = 0; i < K - len; i++) {
                    int j = i + len ;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                    	int num = 0;
                    	if(i>0) {
                    		num = sum[i-1];
                    	}
                        int total = sum[j] - num;
                        if(dp[i][j] > dp[i][k] + dp[k + 1][j] + total) {
                        	dp[i][j] = dp[i][k] + dp[k + 1][j] + total;
                        }
                        
                    }
                }
            }
```

## :black_nib: **Review**  
- dp문제는 점화식을 생각하는데 너무 오래걸리고 어려워요
## 📡**Link**
https://www.acmicpc.net/problem/11066
