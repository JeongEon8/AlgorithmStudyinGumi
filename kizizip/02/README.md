# [백준 - S3] 1966. 프린터 큐


## ⏰ **time**
30분

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. Document 객체를 만듦 (page:문서가 몇번째로 주어졌는지?, priority:중요도)
2. (page, priority) 쌍으로 큐에 추가
3. poll해서 현재 큐 안에 더 높은 우선순위가 있는지 확인. 있으면 뒤로 보내고, 없으면 출력.
4. 실제 출력된 문서 수(count) 증가 
5. 우리가 찾는 문서가 나오면 현재까지 출력된 순서를 출력하고 종료 

## :black_nib: **Review**
재미있어요

## 📡**Link**
https://www.acmicpc.net/problem/1966
