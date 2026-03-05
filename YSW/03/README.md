# [백준 - S4] 2090. 조화평균 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현
- 정수론
- 유클리드 호제법

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

이 문제는 여러 개의 수가 주어졌을 때 조화평균을 분수 형태로 구하는 문제입니다.
문제에서 조화평균은 N개의 수 A[1], …, A[N]의 조화평균은 1/(1/A[1] + 1/A[2] + … + 1/A[N]) 으로 정의되었습니다.
위 식을 그대로 계산하면 분수 연산이 반복적으로 발생하기 때문에 계산이 복잡해집니다.
이를 해결하기 위해 모든 분수를 하나의 공통 분모로 통일하는 방식을 사용했습니다.
먼저 모든 수의 곱을 mul 변수에 저장합니다.

그러면 각 항의 역수는 다음과 같이 표현할 수 있습니다.
1 / a_i = mul / (a_i \* mul)
따라서 분모 부분인
(1 / a_1) + (1 / a_2) + ... + (1 / a_n)
을 계산할 때 mul / a_i 값을 모두 더하면, 공통 분모가 mul인 분수 형태로 표현할 수 있습니다.
이때 분자는 sum = Σ(mul / a_i), 분모는 mul 이 됩니다.

최종적으로 결과는 mul/sum 형태의 분수가 되며, 기약분수로 만들기 위해 유클리드 호제법을 이용한 최대공약수(GCD) 를 구하여 분자와 분모를 나누어 출력했습니다.

```java
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			mul *= nums[i];
		}

		for (int i = 0; i < N; i++) {
			sum += mul / nums[i];
		}

		long gcd = gcd(sum, mul);

		System.out.println((mul / gcd) + "/" + (sum / gcd));


	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2090
