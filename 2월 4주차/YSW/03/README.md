# [백준 - S2] 31288. 캬루 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 애드 혹
- 정수론
- 해 구성하기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

소수가 주어지면 한자리 수가 다른 소수가 아닌 수와 약수를 구해야하는 문제였다.
3의 배수는 자릿수의 합이 3의 배수이면 해당 수는 3의 배수이다.
이 성질을 이용해 문제를 해결했다.
먼저 주어진 소수 P의 모든 자리수를 더해 sum을 구한다. 이후 각 자리 i에 대해 기존 자리 숫자 currentDigit을 sum에서 빼고, 0~9 사이의 다른 숫자 target을 더해 새로운 합 newSum을 만든다.
이때 newSum % 3 == 0 이라면, 해당 수는 3의 배수가 되므로 소수가 아니다. 따라서 그 자리의 숫자를 target으로 바꾼 새로운 수를 만들어 출력하고, 약수로 3을 함께 출력한다.
이 과정을 통해 원래 소수와 한 자리만 다르면서, 확실하게 합성수(3의 배수)가 되는 수를 각 자리마다 하나씩 구할 수 있다.


```java
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += (P.charAt(i) - '0');
			}

			for (int i = 0; i < N; i++) {
				int currentDigit = P.charAt(i) - '0';
				boolean found = false;

				for (int target = 1; target <= 9; target++) {
					if (target == currentDigit)
						continue;

					int newSum = sum - currentDigit + target;

					if (newSum % 3 == 0) {
						StringBuilder Q = new StringBuilder(P);
						Q.setCharAt(i, (char) (target + '0'));
						sb.append(Q.toString()).append(" 3\n");
						found = true;
						break;
					}
				}

				if (!found && i > 0) {
					int newSum = sum - currentDigit + 0;
					if (newSum % 3 == 0) {
						StringBuilder Q = new StringBuilder(P);
						Q.setCharAt(i, '0');
						sb.append(Q.toString()).append(" 3\n");
					}
				}
			}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/31288