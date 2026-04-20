# [백준 - S5] 18511. 큰 수 구성하기


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 브루트포스 알고리즘
- 재귀

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
집합으로 만들 수 있는 n보다 작은 수를 모두 돌면서 가장 큰 수를 찾는다.
```java
static void solve(int current) {
		if (current > n)
			return;
		ans = Math.max(ans, current);
		for (int i = k - 1; i >= 0; i--) {
			solve(current * 10 + arr[i]);
		}
	}
```

## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/18511