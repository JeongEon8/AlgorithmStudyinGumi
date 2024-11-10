# [백준 - S1] 1629. 곱셈

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(log N)$

## :round_pushpin: **Logic**

모듈러 연산의 특성 (a*b)%c= a%c*b%c 과 지수 연산 a^12=a^6*a^6 이용하기

```java
	private static long newPow(long n, long m) {
        if (m == 1) return n;
        long temp = newPow(n, m / 2);

        if (m % 2 == 1) {
            return (temp * temp % k) * n % k;
        }
        return temp * temp % k;
    }
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/1629
