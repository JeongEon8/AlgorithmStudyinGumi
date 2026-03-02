# [백준 - S2] 5636. 소수 부분 문자열 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 문자열
- 브루트포스 알고리즘
- 정수론
- 소수 판정
- 에라토스테네스의 체

## ⏲️**Time Complexity**

$O(100000 log log 100000) + O(len)$

## :round_pushpin: **Logic**

먼저 에라토스테네스의 체를 이용해 100000 이하의 소수 여부를 미리 계산해 둔다.
이후 입력 문자열의 모든 시작 위치 i에 대해, 길이가 최대 6자리인 부분 문자열을 생성하여 정수로 변환한다. 해당 값이 100000 이하이면서 소수라면, 현재까지의 최댓값과 비교하여 갱신한다.

```java
		precomputePrimes();
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;

			int maxPrime = 0;
			int len = s.length();

			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j <= len && j <= i + 6; j++) {
					String sub = s.substring(i, j);
					int num = Integer.parseInt(sub);

					if (num <= 100000 && isPrime[num]) {
						maxPrime = Math.max(maxPrime, num);
					}
				}
			}
			System.out.println(maxPrime);
		}

	static void precomputePrimes() {
		for (int i = 2; i <= 100000; i++)
			isPrime[i] = true;
		for (int i = 2; i * i <= 100000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 100000; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/5636
