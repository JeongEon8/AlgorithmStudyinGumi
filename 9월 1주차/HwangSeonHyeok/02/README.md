# [PGS - LV2] 12973. 괄호 회전하기

## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 구현
- 스택

## ⏲️**Time Complexity**

$O(n^2)$

## :round_pushpin: **Logic**
for문에서 각 괄호의 회전한 string을 스택에 넣어서 괄호싀 쌍을 다 맞출 수있는지 확인한다.
```java
for(int i = 0; i<s.length(); i++){
	String rotateS = s.substring(i)+s.substring(0,i);
	boolean isRight = true;
	Stack<Character> stack = new Stack<>();
	for(char c : rotateS.toCharArray()){
		if(c=='('||c=='['||c=='{'){
			stack.push(c);
		}else{
			if(stack.isEmpty()){
				isRight = false;
				break;
			}
			char topChar = stack.pop();
			if(c==')'&&topChar!='('){
				isRight = false;
				break;
			}
			if(c==']'&&topChar!='['){
				isRight = false;
				break;
			}
			if(c=='}'&&topChar!='{'){
				isRight = false;
				break;
			}
		}
	}
	if(!stack.isEmpty()){
		isRight = false;
	}
	if(isRight)answer++;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/76502