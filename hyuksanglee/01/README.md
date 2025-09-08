# \[백준 - 골드 4] 1744. 수 묶기

## ⏰  **time**

60분

## \:pushpin: **Algorithm**

그리디 + 우선순위 큐, dp

## ⏲️**Time Complexity**

O(N log N)

## \:round\_pushpin: **Logic**
그리디
1. 2이상 양수 우선순위큐, 음수 우선순위큐, 1의개수, 0의개수 담는 객체 생성.
2. 2이상은 갯수가 홀수 이면 한개를 먼저 더하고 나머지는 두개씩 곱해서 더해준다.
3. 음수는 음수 2개를 곱하면 양수가 되므로 두개씩 곱해서 더해준다.(한개가 남을시 0이 있으면 곱해서 없애준다)
4. 1의 개수만큼 더해준다.

```java
// 우선순위 큐에는 작은 순부터이므로 홀수이면 작은수를 더해준다.
		if(plus.size()%2 == 1) {
			result +=plus.poll();
		}
		
		// 나머지 2이상 값들을 2개씩 곱해준다.
		while(!plus.isEmpty()) {
			int sum = 0;
		
			sum = plus.poll() * plus.poll();
			
			result += sum;
		}
		
		
		while(!minus.isEmpty()) {
			
			// 음수끼리 곱하면 양수가 되므로 2개씩 곱해준다.
			if(minus.size()>1) {
				result += minus.poll() * minus.poll();
			}else {
				// 한개 남았을때는 0이 있으면 곱해서 상쇄시켜주고 아니면 결과값에 더해준다.
				if(zero>0) {
					zero--;
					minus.poll();
				}else {
					result+= minus.poll();
				}
			}
		
		}
		
```
dp
1. 정렬 시킨다.
2. +했을 경우 *경우를 받기 위해 2차원 dp 배열 생성
3. 더할겨우는 이전 값에서 최댓값에 현재값을 더해주고
4. 곱할경우는 전전값에서 최댓값에 이전값과 현재값 곱해서 더해준다.

```java
Arrays.sort(number);
		
		int[][]dp = new int[2][N+1];
		
		for(int i =0; i<N; i++) {
			if(i==0) {
				dp[0][1] =number[i];
				dp[1][1] =number[i];
			}else if(i == 1){
				dp[0][2] = number[i]+dp[0][1];
				dp[1][2] = number[i]*dp[0][1];
			}else {
				int max = dp[1][i];
				if(dp[0][i]> dp[1][i]) {
					max = dp[0][i];
				}
				dp[0][i+1] = number[i] +max;
				
				max = dp[1][i-1];
				if(dp[0][i-1]> dp[1][i-1]) {
					max = dp[0][i-1];
				}
				
				dp[1][i+1] = number[i]*number[i-1] +max;
			}
		}
```

## \:black\_nib: **Review**

* 2가지 방법으로 풀어봤는데 그리디가 1시간 이상걸렸는데 dp로 풀때는 20분 밖에 안걸렸어요

## 📡 Link

[https://www.acmicpc.net/problem/1744)
