# [백준 - S4] 28278. 스택 2 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 자료 구조
- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

이 문제는 스택 자료구조의 기본 연산(push, pop, peek, size, isEmpty)을 그대로 구현하는 문제입니다.
입력 명령에 따라 스택을 조작하고, 결과를 출력하면 된다.

```java
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
			} else if (command == 2) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (command == 3) {
				sb.append(stack.size()).append("\n");
			} else if (command == 4) {
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			} else if (command == 5) {
				sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/28278