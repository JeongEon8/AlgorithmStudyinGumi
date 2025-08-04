# [백준- G2] 1918. 후위 표기식
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 연산자는 스택에 닿고 규칙에 맞게 뽑아주기
  1. 알파벳일 경우 스택에 안 담고 result 바로 담기
  2. 연산자 일경우 스택에 담는다
  3. 괄호가 닫이거나 (*,/)가 스텍 제일 위에 있고 다음 넣을게 (+,-)이면 스택안에 있는거 뽑아내고 (+,-)담기
  4. 스텍이 비어있을때까지 반복


```java
	for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				result.append(c);
			} else if (c == '(') {
				si.push(c);
			} else if (c == ')') {
				while (!si.isEmpty() && si.peek() != '(') {
					result.append(si.pop());
				}
				if (!si.isEmpty()) si.pop(); 
			} else { 
				while (!si.isEmpty() && precedence(si.peek()) >= precedence(c)) {
					if (si.peek() == '(') break;
					result.append(si.pop());
				}
				si.push(c);
			}
		}

		while (!si.isEmpty()) {
			result.append(si.pop());
		}
```

## :black_nib: **Review**
- if문만 잘 작성하면 되는 문제에요

## 📡**Link**
- https://www.acmicpc.net/problem/1918
