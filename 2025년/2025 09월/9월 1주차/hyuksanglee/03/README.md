# \[백준 - 골드 5] 15486. 퇴사 2

## ⏰  **time**

40분

## \:pushpin: **Algorithm**

dp

## ⏲️**Time Complexity**

O(N)


## \:round\_pushpin: **Logic**

1. N 크기의 dp 배열 생성
2. 현재 날짜 + 걸리는 일수 에 오늘까지에 상담 누적금액과 오늘 부터 예정 상담 금액을 더한 값이랑 비교하여 최댓값으로 갱신

```java
// 일수만큼 반복
		for(int n = 0; n<N; n++) {
			String[] input = in.readLine().split(" ");
			
			// 상담에 걸리는 시간
			int T = Integer.parseInt(input[0]);
			
			// 금액
			int P = Integer.parseInt(input[1]);
			
			// 현재까지 상담금액 최댓값으로 갱신
			if(n>0) {
				if(meet[n-1] > meet[n]) {
					meet[n] = meet[n-1];
				}
			}
			
			// 현재날짜의 최댓금액과 오늘 상담금액 합
			int pay = meet[n]+ P;
			
			// 상담일수가 N보다 초과가 아닐경우
			if(T+n<=N) {
				
				//현재까지 최댓값 갱신
				if(result<pay) {
					result = pay;
				}
				
				//오늘날짜의 상담금액이 지금까지 누적 금액보다 클 경우 갱신
				if(pay > meet[T+n]) {
					meet[T+n] = pay;
				}
				
			}
			
		}
```



## \:black\_nib: **Review**

* dp 점화식 세우기가 힘든데 이번문제는 쉽네요

## 📡 Link

[https://www.acmicpc.net/problem/15486)
