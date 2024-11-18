# [백준 - S4] 9012. 괄호

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

스택을 이용하여 (이면 push )이면 pop해서 괄호 성립의 여부를 확인

```java
	for (int j = 0; j < s.length(); j++) {
				if (!check)
					break;
				char now = s.charAt(j);
				if (now == ')') {
					if (!st.isEmpty()) {
						st.pop();
					} else {
						check = false;
					}
				} else if (now == '(') {
					st.push(now);
				}
			}
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/9012
