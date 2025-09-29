# [프로그래머스 - 2] 올바른 괄호


## ⏰ **time**
15분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
1. `(`가 나오면 stack에 넣는다
2. `)`가 나오면, stack에 짝이 있는지 확인하고, 없으면 false 리턴
3. 있다면, stack에서 `(` 하나를 꺼낸다 (소비한다)
4. 끝까지 읽은 후, stack이 깔끔하게 비었는지 여부를 리턴


## :black_nib: **Review** 
처음엔 char 말고 String 썼는데 효율성 오바됐음 ㅋㅋ 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12909
