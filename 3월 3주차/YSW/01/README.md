# [백준 - G5] 2436. 공약수 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘
- 정수론
- 유클리드 호제법

## ⏲️**Time Complexity**

$O( (L/G)^1/2 * log (L/G)^1/2)$

## :round_pushpin: **Logic**

최대공약수(L)와 최소공배수(G)가 주어졌을때 L과G를 최대공약수, 최대공배수로 같는 수 두 수 A,B가 A+B의 값이 최소가 되는 값을 찾는 문제 였다.
A = a*G
B = b*G
L = a*b*G
a*b의 약수 i와 i와 곱했을때, a *b가 되는수 중에 최대공약수가 1인 서로소인 경우 중에 합이 최소인 값을 찾는다.

```java
		int target = lcm / gcd;
		int resA = 0;
		int resB = 0;
		for (int i = 1; i * i <= target; i++) {
			if (target % i == 0) {
				int a = i;
				int b = target / i;

				if (getGCD(a, b) == 1) {
					if (minSum > a + b) {
						minSum = a + b;
						resA = a * gcd;
						resB = b * gcd;
					}
				}
			}
		}

	public static int getGCD(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2436
