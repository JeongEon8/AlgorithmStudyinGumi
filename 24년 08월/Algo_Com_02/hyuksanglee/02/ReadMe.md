# [백준 - G3] 1644. 소수의 연속합
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
투 포인터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력 받은 수 이하의 소수찾기
  
2. for문으로, 연속되는 소수 값 더하기

3. 합이 입력 받은 값보다 클 경우 while문으로 작아질때까지 뺴기
```java
		for(int i = 0; i<num; i++) { // (투 포인트 구현)
			
			total += arr[i]; // 연속되는 소수 더하기
			
			while(total > N) { // 합이 입력받은 값보다 클 경우
				total -= arr[arrN++]; // 더했던 소수 증에 제일 작은 소수 빼기
			}
			
			if(total == N) {
				total -= arr[arrN++];
				count++; // 횟수 추가
			}
			
			
		}
```

## :black_nib: **Review**
- 소수를 찾을때 이중 for문을 사용하니 시간이 부족했어요
- 에라토스테네스의 체를 사용하니 시간 문제 해결👍

  ## 📡**Link**

- https://www.acmicpc.net/problem/1644
  



  
