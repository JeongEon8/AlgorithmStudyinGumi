# [백준 - S3] 11899. 괄호 끼워넣기 (Easy)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

Stack 안에 ()이렇게 들어 갈 수 있으면 빼고 ()모양이 안 나올때는 Stack 안에 넣는 식으로 구현했다.

```java
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (currentChar == ')' && !stack.isEmpty()) {
				if (stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(currentChar);
				}
			} else {
				stack.push(currentChar);
			}
		}
```

## :black_nib: **Review**

Stack의 기본적인 활용법을 다시 한번 다질 수 있었다.

## 📡**Link**

https://www.acmicpc.net/problem/11899
