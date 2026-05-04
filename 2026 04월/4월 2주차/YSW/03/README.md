# [백준 - S1] 27973. 지연 평가 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 애드 혹
- 사칙연산

## ⏲️**Time Complexity**

$O(Q)$

## :round_pushpin: **Logic**

전체 원소에 적용되는 변환 상태를 변수로 관리하는 문제였다.
모든 원소를 s_i라고 할 때, 연산 결과는 항상 일차함수 $f(s) = a * s + b$ 꼴이 된다.
0 x 명령어가 들어올 때는 모든 원소에 x를 더하므로 $b = b + x$로 바꿔주고,
1 x 명령어가 들어올 때는 모든 원소에 x를 곱하므로 기존의 $a * s + b가 (a * s + b) * x$가 되어야 하므로 $a = a * x$, $b = b * x$로 바꿔주고
2 n 명령어가 들어올 때는 가장작은 값부터 n개를 지우므로 원본 값들은 1씩 증가하는 연속된 수이므로, s에 n을 더해주기만 하면 된다.
3 명령어가 들어올 때는 현재 상태가 적용된 $a * s + b$를 출력하면 된다.

```java
		long multiplier = 1;
		long origin = 1;
		long adder = 0;
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command != 3) {
				long x = Long.parseLong(st.nextToken());
				if (command == 0) {
					adder += x;
				} else if (command == 1) {
					multiplier *= x;
					adder *= x;
				} else if (command == 2) {
					origin += x;
				}
			} else {
				long res = multiplier * origin + adder;
				sb.append(res).append("\n");
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/27973
