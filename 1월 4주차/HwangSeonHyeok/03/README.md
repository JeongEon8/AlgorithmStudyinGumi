# [백준 - S2] 26597. 이 사람 왜 이렇게 1122를 좋아함?

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
^의 최대값과 v의 최소값의 차가 2여야 답을 구할 수있다. 이외에는 모순이거나 답을 특정할 수 없는 경우를 고려하면된다.
```java
for (int i = 1; i <= n; i++) {
	String[] split = in.readLine().split(" ");
	long x = Long.parseLong(split[0]);
	if (split[1].equals("^") && x > bottom) {
		bottom = x;
	} else if (split[1].equals("v") && x < top) {
		top = x;
	}
	if (ans == 0 && bottom + 2 == top) {
		ans = i;
	} else if (isAble && top <= bottom + 1) {
		ans = i;
		isAble = false;
	}
}
```

## :black_nib: **Review**
-1e18 ~ 1e18dl 이 답일 수 있어서 최저, 최대는 각각 1씩빼거나 더해야하는데 이를 빼먹었다.

## 📡**Link**

https://www.acmicpc.net/problem/26597
