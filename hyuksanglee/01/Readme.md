# [백준 - G5] 13549. 숨바꼭질 3

## ⏰ **time**

1시간

## :pushpin: **Algorithm**

- dp

## ⏲️**Time Complexity**

$O(N)^2$

## :round_pushpin: **Logic**

- dp의 값을 담는 리스트 생성
- 점화식 : dp[n-1][k] 이랑 dp[n-1][k-V]+C 둘이 비교해서 큰 값 넣기
  	- dp[n-1][k] : 현재 값을 넣지 않았을때 부피k 일때 최댓값
  	- dp[n-1][k-V]+C : 현제 값을 넣고 남는 부피만큼 중에서 최댓값을 더한값

```java
	 for (int n = 1; n <= N; n++) {
                input = in.readLine().split(" ");
                int V = Integer.parseInt(input[0]);
                int C = Integer.parseInt(input[1]);

                for (int j = 0; j <= K; j++) {
                    dp[n][j] = dp[n - 1][j];
                    if (j >= V) { 
                        dp[n][j] = Math.max(dp[n][j], dp[n - 1][j - V] + C);
                    }
                }
            }
```

## :black_nib: **Review**
- dp는 너무 어려워요


## 📡**Link**

https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr&categoryId=AY1INdsqPvADFAWX&categoryType=BATTLE&battleMainPageIndex=1&&&&
