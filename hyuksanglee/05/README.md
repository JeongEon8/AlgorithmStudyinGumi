# [백준 - S5] 3986. 좋은 단어

## ⏰ **time**

20분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 스택을 활용해서 이전 값이랑 비교해 값으면 뺴주고 다르면 넣어준다.
- 마지막으로 스택이 비어있으면 좋은단어
```java
   for(int n = 0 ; n<N; n++) {
			String input = in.readLine();
			Stack<Character> st =new Stack<>();
			for(int i =0; i<input.length(); i++) {
				char c = input.charAt(i);
				if(st.isEmpty()) {
					st.add(c);
				}else {
					char pc = st.peek();
					if(pc==c) {
						st.pop();
					}else {
						st.add(c);
					}
				}
				
			}
			if(st.size()==0) {
				result++;
			}
			
		}
```



## :black_nib: Review
- 
## 📡**Link**

- [https://www.acmicpc.net/problem/3986](https://www.acmicpc.net/problem/3986)
