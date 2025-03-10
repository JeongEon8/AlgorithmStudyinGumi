# [백준 - S3] 21921. 블로그

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 지정된 일자만큼 윈도우를 만들기
2. 끝까지 이동하면서 크기 확인 후 갯수 체크

```java
	for(int i=k; i<n; i++) {
			sum-=list[i-k];
			sum+=list[i];
			if(large<sum) {
				large=sum;
				count=1;
			} else if(large==sum)count++;
		}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/21921
