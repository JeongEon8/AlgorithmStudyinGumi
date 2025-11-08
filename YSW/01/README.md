# [백준 - G4] 14881. 물통 문제 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 정수론
- 유클리드 호제법

## ⏲️**Time Complexity**

$O(log(min(a,b)))$

## :round_pushpin: **Logic**

유클리드 호제법을 이용해서 두 수의 최대 공약수를 구하고 최대공약수로 c가 나눠지면 YES 아니면 NO를 출력한다.

```java
		a = Math.abs(a);
		b = Math.abs(b);
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/14881
