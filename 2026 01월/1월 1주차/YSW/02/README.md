# [백준 - S3] 6591. 이항 쇼다운 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 조합론

## ⏲️**Time Complexity**

$O(k)$

## :round_pushpin: **Logic**

n개의 원소 중에 k개를 순서 없이 뽑는 조합 문제였다. 조합의 수 공식이 nCk 일때 n!/k!(n-k)! 이여서 아래 처럼 구했다.

```java
			long combinationCount = 1;
			for (int i = 0; i < k; i++) {
				combinationCount = combinationCount * (n - i) / (i + 1);
			}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/6591
