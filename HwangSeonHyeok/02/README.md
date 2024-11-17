# [백준 - S4] 1980. 햄버거 사랑

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

더 적은 먹는 시간을 n이라 할때 그 버거를 최대한 먹는 경우 콜라를 먹는 시간이 t%n이다. 더 많은 시간이 걸리는 경우 m을 한개씩 늘려가면서 콜라 먹는 시간을 계산해서 콜라먹는 시간이 가장 적으면서 버거를 많이 먹는 경우를 찾는다.

```java
	while (t > 0) {
		int tmpBurger = cnt + t / n;
		int tmpcolar = t % n;
		if (tmpcolar < colar) {
			colar = tmpcolar;
			burger = tmpBurger;
		}
		if (colar == 0)
			break;
		t -= m;
		cnt++;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1980
