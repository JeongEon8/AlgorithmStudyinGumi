# [백준 - S3] 19941. 햄버거 분배

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(NK)$

## :round_pushpin: **Logic**
먹을 수 있는 범위에서 항상 가장 왼쪽 버거를 먹는 식으로 그리디하게 접근하면 답을 구할 수 있다.

```java
	int[] arr = new int[n+1];//0은 사람 1은 버거 2는 버거먹고 남은자리.
	for (int i = 0; i < n; i++) {
		if(str.charAt(i)=='H') {
			arr[i] = 1;
		}
	}
	int ans = 0;
	for(int i = 0; i<n;i++) {
		if(arr[i]!=0)continue;
		for(int j = Math.max(i-k,0);j<=Math.min(i+k,n-1);j++) {
			if(arr[j]==1) {
				ans++;
				arr[j] = 2;
				break;
			}
		}
	}
```

## :black_nib: **Review**

예전에 풀었던 보트빌려주는 문제랑 거의 같은거같다.

## 📡**Link**

https://www.acmicpc.net/problem/19941
