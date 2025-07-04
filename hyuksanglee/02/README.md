# [백준- G4] 1253. 좋다
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(N × M × K)$

## :round_pushpin: **Logic**
- 정렬을 시키고 작은 값과 큰 값을 비교해서 해당 값이 있는지 비교 있으면 count 하나 증가시키고 해당 값보다 더한 값이 크면 큰값에서 그다음 큰값으로 계산, 작으면 작은 값보다 그다음 작은 값을 계산 해서 비교 한다.

```java
	for(int n = 0; n<N; n++) {
			int num = nums[n];
			
			int l = 0;
			int r = N-1;
			
			while(l<r) {
				if(l == n) {
					l++;
					continue;
				}
				else if(r ==n) {
					r--;
					continue;
				}
				
				int sum = nums[l]+ nums[r];
				
				if(sum == num) {
					count++;
					break;
				}
				if(sum>num) {
					r--;
				}
				else {
					l++;
				}
			}
			
		}
```

## :black_nib: **Review**
- 처음에는 3중 for문을 써서 풀었더니 시간 초과뜨더라구요. 투 포인터로 푸니깐 해결!! 투 포인터 입력

## 📡**Link**
- https://www.acmicpc.net/problem/1253
