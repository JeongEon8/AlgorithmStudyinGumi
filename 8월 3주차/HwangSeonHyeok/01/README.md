# [PGS - LV2] 12973. 짝지어 제거하기

## ⏰ **time**

	10분

## :pushpin: **Algorithm**
- 구현
- 스택

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
스택의 위와 비교하면서 같은 알파벳이면 제거하고 아니면 스택에 넣는 식으로 짝을 없에준다.
```java
Stack<Character> st = new Stack<>();
for(int i = 0; i<s.length(); i++){
	if(!st.isEmpty() && st.peek()==s.charAt(i)){
		st.pop();
	}else{
		st.push(s.charAt(i));
	}
}
if(st.isEmpty()){
	answer = 1;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12973