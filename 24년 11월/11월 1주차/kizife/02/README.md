# [백준] 1026. 보물 
 
## ⏰  **time**
10분 

## :pushpin: **Algorithm**
수학, 정렬 

## ⏲️**Time Complexity**
O(n log n)

## :round_pushpin: **Logic**
각 값을 arraylist에 저장한다.
가장 큰 수 * 가장 작은 값... 들을 합해야 가장 작은 값이 나온다.
그래서 오름차순 정렬을 하고, A리스트는 순서대로, B리스트는 거꾸로 꺼내며 곱했다.(arraylist를 배열로 옮김...)
```java
		for (int i = 0; i < n; i++) {
			int num = arrA[i] * arrB[n-1-i];
			
			result += num;
		}
```

## :black_nib: **Review**
- 피곤해서 쉬운 문제 풀었습니다아 그 어떤 함정도 없는 단순한 문제... 

## 📡**Link**
- https://www.acmicpc.net/problem/1026 
