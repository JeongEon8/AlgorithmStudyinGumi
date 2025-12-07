# [백준 - S2] 12993. 이동3 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 정수론

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

이 문제는 각 단계 k에서 3^k만큼 이동해야 하므로 3의 거듭제곱들을 순서대로 x 또는 y 중 하나에 반드시 배정해야 한다.
3의 거듭제곱은 큰 값 하나가 이전 모든 값 합보다 크기 때문에,
어떤 3^k가 누구에게 배정될지는 greedy하게 결정해도 항상 정답이 보장된다.
그래서 이 코드는 3의 거듭제곱을 미리 계산한다. 사용할 수 있는 가장 큰 3^k부터 현재 x와 y 중 더 큰 좌표가 그 3^k를 가져가도록 값을 빼 나가고 모든 3^k를 배분한 후 x와 y가 정확히 0이 되면 도달 가능하다고 판단한다.

```java
		for (int i = 1; i < 20; i++) {
			pow[i] = pow[i - 1] * 3;
			if (pow[i] > Math.max(x, y)) {
				limit = i - 1;
				break;
			}
		}

		for (int i = limit; i >= 0; i--) {
			if (x > y) {
				x -= pow[i];
			} else {
				y -= pow[i];
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/12993
