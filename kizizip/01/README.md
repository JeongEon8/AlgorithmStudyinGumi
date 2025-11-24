# [백준 - S5] 1316. 그룹 단어 체커

## ⏰ **time**

20분

## :pushpin: **Algorithm**

구현, 문자열

## ⏲️**Time Complexity**



## :round_pushpin: **Logic**
1. 단어를 순회하면서, 직전에 본 문자와 현재 문자를 비교
2. 다른 문자로 바뀐 시점에서, 현재 문자가 과거에 등장한 적이 있으면: 그룹 단어 기준 위반
3. 아직 등장하지 않은 문자: 방문 처리 후 계속 진행
4: 끝까지 위반이 없으면: 해당 단어를 그룹 단어로 인정

## :black_nib: **Review** 
벌금을 피하기 위한 몸부림 

## 📡**Link**
https://www.acmicpc.net/problem/1316
