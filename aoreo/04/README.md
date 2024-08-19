# [SWEA - D4] 1223. [S/W 문제해결 기본] 6일차 - 계산기2
 
## ⏰  **time**

15분 
  
## :pushpin: **Algorithm**
스택
  
## ⏲️**Time Complexity**
$O(N)$
    
## :round_pushpin: **Logic**
#### Step 1. 후위표기법으로 변환
1. 연산자들을 담을 Character 타입 스택 생성
2. 표기법을 담을 String 생성
3. 받아온 값이 숫자일 경우 expression에 추가
4. 숫자가 아닐 경우
1) '('일 경우, 스택에 add
2) ')'일 경우, 짝꿍인 '('가 나올 때까지 pop하며 expression에 추가
3) '+'일 경우, 스택의 최상단이 '*'나 '+'이 아닐 때까지 pop하며 expression에 추가하고, 스택에 '+'를 add
4) '*'일 경우, 스택의 최상단이 ''이 아닐 때까지 pop하여 expression에 추가하고, 스택에 ''를 add

#### Step 2. 후위표기법으로 계산하기
1. 피연산자들을 담을 Integer 타입 스택 생성
2. expression의 길이만큼 반복하며, 꺼낸 값이 숫자일 경우 스택에 추가
3. 숫자가 아닐 경우, 두 값을 pop하여 연산자대로 계산해서 스택에 추가

#### Step 3. 값 출력
operand 스택에 마지막으로 남아있는 값(최상단에 있는 값)이 결과값이므로 해당 값 반환.

## :black_nib: **Review**
- 기존에 풀었던 것과 거의 동일한 문제라 완전 쉽게 봤는데.. 그 문제보다 처리해야 할 것들이 있었다...
- while은 if와 다르게 앞 조건을 만족하지 않는다고 빠져나가지 않네.....으앙
- 이 부분에서 왕 오래걸림...
- 그리고... 왜 마지막 연산자 안 데려가
  
## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV14nnAaAFACFAYD&categoryId=AV14nnAaAFACFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2
