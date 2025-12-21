# [백준 - S4] 13706. 제곱근 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 이분 탐색
- 임의 정밀도 / 큰 수 연산

## ⏲️**Time Complexity**

// k는 자리수
$O(k^2)$

## :round_pushpin: **Logic**

n의 자리수가 800자리가 넘어가서 자리수 제한이 없는 BigInteger를 사용했다.

```java
		BigInteger n = new BigInteger(br.readLine());
		BigInteger sqrtN = n.sqrt();

		System.out.println(sqrtN);
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/13706
