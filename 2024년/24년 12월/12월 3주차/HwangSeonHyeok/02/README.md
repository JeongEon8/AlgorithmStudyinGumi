# [백준 - S3] 20309. 트리플 소드

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 정렬
- 애드 혹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
문제에 나온 트리플 소트 방식으로는 index가 홀수끼리 짝수끼리만 위치를 바꿀 수 있다.  
배열의 index는 0에서 시작하므로 모든 홀수는 짝수 index에 모든 짝수는 홀수 index에 있어야 정렬 가능하다.


```java
	boolean able = true;
	for (int i = 0; i < n; i++) {
		if (Integer.parseInt(split[i]) % 2 == i % 2) {
			able = false;
			break;
		}
	}
	if (able) {
		System.out.println("YES");
	} else {
		System.out.println("NO");
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20309
