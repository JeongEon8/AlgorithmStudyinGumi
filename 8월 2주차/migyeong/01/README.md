
# [백준- G5] 2504. 괄호의 값

## ⏰  **time**
60분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
O(N)

## :round_pushpin: **Logic**
- 여는 괄호는 스택에 쌓고, 현재 괄호 구조의 곱셈값을 value 함수에 곱셈
- 닫는 괄호가 나왔을 때 스택에서 빼고 최종 result 값에 덧셈

```java
for(int i = 0; i < input.length(); i++) {
		if(input.charAt(i) == '(') {
			stack.push(input.charAt(i));
			value *= 2;
		}
		else if(input.charAt(i) == '[') {
			stack.push(input.charAt(i));
			value *= 3;
		}
		else if(input.charAt(i) == ')') {
			if(stack.isEmpty() || stack.peek() != '(') {
				result = 0;
				break;
			} else if (input.charAt(i-1) == '(') {
				result += value;
			}
			stack.pop();
			value /= 2;
		}
		else if(input.charAt(i) == ']') {
			if(stack.isEmpty() || stack.peek() != '[') {
				result = 0;
				break;
			} else if (input.charAt(i-1) == '[') {
				result += value;
			}
			stack.pop();
			value /= 3;
		}
	}
```

## :black_nib: **Review**
괄호 구하기가 너무 어렵더라구요

## 📡**Link**
- https://www.acmicpc.net/problem/2504

