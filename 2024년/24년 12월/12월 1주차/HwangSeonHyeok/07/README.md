# [백준 - S5] 16395. 파스칼의 삼각형

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍
- 조합론

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
n이 크지 않아 파스칼의 삼각형을 모두 기록해두고 입력받은 위치의 값을 출력하였다.

```java
	for(int i = 2;i<31;i++) {
		for(int j = 1; j<=i;j++) {
			pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
		}
	}

```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/16395
