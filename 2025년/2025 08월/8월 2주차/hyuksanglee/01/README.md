
# [백준- G5] 12865. 평범한 배낭
## ⏰  **time**
60분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N*K)$

## :round_pushpin: **Logic**

- 물품을 입력 받을때 이전에 입력 된값이랑 비교해서 최대값으로 갱신 해준다.
  	- 가방 최대 무게가 10이고 물품 무게가 7이면
  		- dp[10] = 입력받은 물품 가치 + dp[3]
  		- dp[9] = 입력받은 물품 가치 + dp[2]
  	  		...
  	   	- dp[7] = 입력받은 물품 가치 + dp[0]
	- 마지막에 dp[10] 출력해준다.

```java
	for (int n = 0; n<N; n++) {
			input = in.readLine().split(" ");
			int W = Integer.parseInt(input[0]); // 물품의 무게
			int V = Integer.parseInt(input[1]);	// 물품의 가치
			
			for(int k = K; k>=W; k--) {
				
				if(dp[k] <= V+dp[k-W]) {
					dp[k] = V+dp[k-W];
				}
			}
			
		}
		
		
		System.out.println(dp[K]);
```

## :black_nib: **Review**
- 여행가고 싶은데 알고리즘으로 대신 ㅠㅠ


## 📡**Link**
- https://www.acmicpc.net/problem/12865

