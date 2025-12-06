# [백준 - S4] 10773. 제로 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 스택

## ⏲️**Time Complexity**

$O(K)$

## :round_pushpin: **Logic**

num이 0이 아니면 stack에 num값을 넣고 0이면 stack에서 값을 빼준다.
stack의 남아있는 값들을 전부 더해서 출력한다.

```java
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/10773
