# [백준 - S2] 11867. 박스 나누기 게임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 게임 이론

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
B에게 짝수인 박스를 넘길 수있으면, 즉 둘 중 돌이 짝수인 박스가 1개라도 있으면 A가 이긴다.
```java
	if(n%2+m%2<2) {
		System.out.println("A");
	}else {
		System.out.println("B");
	}

```

## :black_nib: **Review**

처음에 여타 게임이론 문제처럼 dp로 풀다가 이 문제 같은 경우는 규칙이 명확해서 규칙만 분류하는 쪽으로 바꿨다.

## 📡**Link**

https://www.acmicpc.net/problem/11867
