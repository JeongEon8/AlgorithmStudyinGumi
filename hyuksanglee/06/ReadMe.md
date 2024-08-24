# [백준 - S4] 10773. 제로
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 스텍

## :round_pushpin: **Logic**
1. 정수를 담을수 있는 스택 만든다.

2. for문을 돌면서 해당 0을 제외한 숫자이면 스택에 담기

3. 0이면서 스택이 비어있지 않으면 스택에서 한개를 pop()해준다.

4. 마지막으로 스택 안에 있는 빼서 더해준다.
   
```#java
for (int k = 0; k < K; k++) {
			int N = Integer.parseInt(input.readLine());
			if (N == 0) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(N);
			}
		}
```
## :black_nib: **Review**

- 스택으로 가뿐히 해결!!

## 📡**Link**

- https://www.acmicpc.net/problem/10773
  
