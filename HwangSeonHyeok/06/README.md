# [백준 - G2] 2749. 피보나치 수 3

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- 수학
- 분할 정복을 이용한 거듭제곱

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

피보나치수는  
$F_{2N} = {F_{N+1}}^2 -{F_{N-1}}^2$  
$F_{2N-1} = {F_{N+1}}^2 +{F_{N}}^2$  
을 만족한다. 이를 map에 기록하는 방식으로 분할 정복으로 푼다.  
뺄셈의 모듈러 연산은 나누는수를 다시 더해줘야한다.

```java
static Map<Long, Long> m = new HashMap<>();

	static long fib(long n) {
		if (m.containsKey(n)) {
			return m.get(n);
		}
		if (n % 2 == 0) {
			m.put(n, (long) (Math.pow(fib(n / 2 + 1), 2) % mod - Math.pow(fib(n / 2 - 1), 2) % mod + mod) % mod);
			return m.get(n);
		} else {
			m.put(n, (long) (Math.pow(fib(n / 2 + 1), 2) % mod + Math.pow(fib(n / 2), 2) % mod) % mod);
			return m.get(n);
		}

	}

```

## :black_nib: **Review**

n이 너무 커서 logn으로 풀 방법을 찾기위해 노트에 손으로 써가면서 피보나치 수 규칙을 찾았다.  
풀고나서 풀이를 찾아보니 피사노 주기를 사용한 풀이가 많은것 같다..

## 📡**Link**

https://www.acmicpc.net/problem/2749
