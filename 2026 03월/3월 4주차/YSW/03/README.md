# [백준 - S4] 1980. 햄버거 사랑 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(t/n)$

## :round_pushpin: **Logic**

콜라를 마시는 시간을 최소한으로 할때 버거를 가장 많이 먹을 수 있는 경우의 수를 구하는 문제였다.
타워버거와 불고기버거중에 먹는 시간이 더 작은 시간으로 0부터 시작해서 최대한 먹을 수 있는 개수까지 완전탐색을 해서 답을 구했다.

```java
		for (int i = 0; i <= length; i++) {
			int nBurger = i;
			int currentCoke = t - n * nBurger;
			int mBurger = currentCoke / m;
			currentCoke = currentCoke % m;

			if (minCoke > currentCoke) {
				minCoke = currentCoke;
				maxBurger = nBurger + mBurger;
			} else if (minCoke == currentCoke) {
				maxBurger = Math.max(maxBurger, nBurger + mBurger);
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1980
