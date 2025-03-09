# [백준 - S4] 2217. 로프

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(N log N)$

## :round_pushpin: **Logic**
1. 배열 안에 넣고 정렬한다.

2. 큰순 부터 1증가하여 곱해준다.
   	- [6,5,4,3] 이런식으로 정렬 되었있으면 [ 6*1, 5*2, 4*3, 3*4 ] 이런식으로 정렬한다.

3. 그리고 가장 큰값 출력

```java
	for(int n = 0; n<N; n++) {
			
			arr[n]=arr[n]*(N-n);
			if(max<arr[n]) {
				max = arr[n];
			}
		}
```

## :black_nib: **Review**
정렬....

## 📡**Link**

https://www.acmicpc.net/problem/2217
