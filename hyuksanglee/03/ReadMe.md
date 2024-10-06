# [백준 - 골드3] 1520. 퇴사
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
 DP

## ⏲️**Time Complexity**
$O(M * N)$

## :round_pushpin: **Logic**
1. dp 배열과 최댓값 받는 변수 생성

2. 일수 만큼 for문을 돌려준다.
    - 현재 인덱스의 값과 최댓값 비교후 갱신
    - 상담이 끝나는 날이 퇴사 안에 해당 되면 상담이 끝나는 날짜랑 최댓값 더하기 현재 값을 크기 비교후 갱신해준다.


4. dp안에 최댓값 출력
   ```java
		 for (int n =0; n<N; n++) {
			 String[] input =in.readLine().split(" ");
		 
			int day = Integer.parseInt(input[0]);
			 int price = Integer.parseInt(input[1]);
			 
			// 현재까지의 최대 수익을 갱신
	            if (max < dp[n]) {
	                max = dp[n];
	            }
	            
	         // n + day일에 상담이 끝나는 경우
	            if (n + day <= N) {
	                dp[n + day] = Math.max(dp[n + day], max + price);
	            }
		 }
   ```

## :black_nib: **Review**
- dp너무 어려워요

## 📡 Link
https://www.acmicpc.net/problem/14501
