# [백준 - S5] 9656. 돌 게임 2

## ⏰ **time**

10분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 가져갈수 있는 돌맹이 수가 1또는 3이라서 홀수 일경우 CY, 짝수 일경우 SK이다
```java
   int N = Integer.parseInt(in.readLine());
		
		String result = "CY";
		
		if(N %2==0) {
			result = "SK";
		}
```



## :black_nib: Review
- 너무 쉬운거 풀었나
- solved 랜덤돌려서 나온거에요
## 📡**Link**

- [https://www.acmicpc.net/problem/9656](https://www.acmicpc.net/problem/9656)
