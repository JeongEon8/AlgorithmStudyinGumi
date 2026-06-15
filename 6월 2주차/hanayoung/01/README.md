# [SWEA - D4] 01_[S W 문제해결 기본] 4일차 - 괄호 짝짓기

## ⏰**time**

30

## :pushpin: **Algorithm**

스택

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 전체 문자열을 순회하며, 여는 괄호일 경우엔 push, 닫는 괄호일 경우에는 pop. 
2. 닫는 괄호일 경우 스택 사이즈가 0이거나, isMatching 결과가 false일 경우, answer = 0으로 업데이트 후 탈출
   ```
   for(char c: str) 
{ 
if(c == '{' || c == '[' || c == '(' || c == '<') 
{ 
st.push(c); 
} 
else 
{ 
if(st.size() == 0 || isMatching(st.top(), c) == false) { answer = 0; break; } st.pop(); 
} 
}
   ```
3. 여는 괄호와 닫는 괄호가 맞는지 여부 확인하는 함수
```
bool isMatching(char open, char close) 
{ 
return (open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}' || open == '<' && close == '>'); 
}
```

## :black_nib: **Review**

- 스택 익힐 때 풀어보기 좋은 문제인듯 !

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
