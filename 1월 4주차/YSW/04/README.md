# [백준 - S5] 9625. BABBA (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(k)$

## :round_pushpin: **Logic**

처음 문자가 A로 표시 되어있고, 버튼을 누렀을때, 문자열의 문자가 A는 B로 B는 BA로 바뀐다.
버튼을 누르는 횟수가 주어졌을때, 문자열의 문자 A의 개수와 B의 개수를 구하는 문제였다.
문자열의 B의 개수(bCount) 개수 만큼 tempA를 초기화 해주고 tempB를 문자열의 A의 개수(aCount) + B의 개수(bCount) 만큼 tempB를 초기화 해준다. 그런뒤 aCount = tempA로 로 bCount = tempB로 초기화 해준다. 버튼을 누르는 K번 만큼 반복한뒤 A와 B의 개수를 출력한다.

```java
		for (int i = 0; i < k; i++) {
			int tempA = bCount;
			int tempB = aCount + bCount;
			aCount = tempA;
			bCount = tempB;
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/9625
