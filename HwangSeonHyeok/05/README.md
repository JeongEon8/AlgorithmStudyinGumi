# [백준 - g5] 9660. 돌 게임6

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 게임 이론

## :round_pushpin: **Logic**
돌을 1, 3, 4개 가져가는 경우를 구하다보면 규칙을 찾을 수 있다.  
n mod 7이 2나 0이면 후턴이 이기고 나머지 경우 선턴이 이긴다.

```java
	if (n % 7 == 2 || n % 7 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
```

## :black_nib: **Review**

이 문제는 N의 범위가 너무 커서 단순 dp로 모든 답을 구하는 문제가 아닌 dp를 이용해 얻은 답에서 규칙을 찾는 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/9660
