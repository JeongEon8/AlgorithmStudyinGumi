# [백준 - S2] 10819. 차이를 최대로

## ⏰ **time**

20분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

- 조합을 사용해서 하나씩 다 계산해서 최댓값을 출력시킴
- N이 8이하로 다 탐색해도 시간을 남을거가 판단
```java
   static void dfs(int num, int total, int count) {
		
		if(count ==N) {
			if(max < total) {
				max = total;
			}
			return;
		}
		
		for(int n = 0; n < N; n++) {
			
			if(!check[n]) {
				int sum = total+ Math.abs(num-arr[n]);
				check[n]= true;
				dfs(arr[n], sum, count +1);
				check[n] = false;
			}
		}
		
	}
```



## :black_nib: Review
- 골드 풀다가 실버푸니깐 너무 편안
## 📡**Link**

- [https://www.acmicpc.net/problem/10819](https://www.acmicpc.net/problem/10819)
