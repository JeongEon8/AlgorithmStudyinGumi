# [백준 - S4] 4096. 팰린드로미터


## ⏰ **time**
10분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
O(cnt*s.length())

## :round_pushpin: **Logic**
1. 주어진 수를 문자열로 변환
2. 해당 문자열이 팰린드롬인지 검사
3. 팰린드롬이 아니라면
   - 문자열에 1을 더하는 연산 수행 (addOne)
   - 증가 횟수 +1
   - 다시 팰린드롬 여부 검사
4. 팰린드롬이 될 때까지 반복
5. 누적된 증가 횟수 출력


## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/4096
