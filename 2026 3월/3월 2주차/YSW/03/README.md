# [백준 - S3] 10434. 행복한 소수 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현
- 정수론
- 시뮬레이션
- 소수 판정

## ⏲️**Time Complexity**

$O(T*M^(1/2))$

## :round_pushpin: **Logic**

해당 문제는 주어진 수가 소수인지 판별한 후, 그 수가 행복한 수인지 확인하는 문제이다.
먼저 주어진 수 n이 소수인지 판별한다. 소수 판별은 2부터 n^(1/2)까지의 수로 나누어 떨어지는지 확인하는 방식으로 구현하였다. 만약 나누어 떨어지는 수가 존재하면 소수가 아니므로 false를 반환한다.
그 다음 행복한 수인지 판별한다. 행복한 수는 각 자리의 숫자를 제곱하여 더하는 과정을 반복했을 때 최종적으로 1이 되는 수를 의미한다.
이를 위해 현재까지 나온 값을 HashSet에 저장하여 반복 여부를 확인한다.
반복 과정에서 이미 등장한 값이 다시 나오면 순환이 발생한 것이므로 행복한 수가 아니라고 판단한다.
반대로 계산 과정에서 값이 1이 되면 행복한 수로 판단한다.

```java
	public static boolean isPrimeNumber(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();

		while (n != 1) {
			if (set.contains(n))
				return false;
			set.add(n);

			int sum = 0;
			while (n != 0) {
				int digit = n % 10;
				sum += digit * digit;
				n /= 10;
			}
			n = sum;
		}

		return true;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/10434
