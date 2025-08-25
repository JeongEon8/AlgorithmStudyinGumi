# [백준 - S4] 3986. 좋은 단어


## ⏰ **time**
30분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
O(N)

## :round_pushpin: **Logic**
- 한 줄씩 그 단어가 "좋은 단어"인지 판별하는 문제
- 스택에 단어의 첫 글자부터 넣어서, 다음 단어가 다른게 나오면 스택에 추가
- 같은게 나오면 스택에서 기존에 있던걸 제거한다
- 이 과정이 끝나고 나서 stack이 비어있으면 좋은 단어다.

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/3986
