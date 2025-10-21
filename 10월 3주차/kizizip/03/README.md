# [프로그래머스 - lv.2] 귤 고르기


## ⏰ **time**
25분

## :pushpin: **Algorithm**
해시맵, 정렬

## ⏲️**Time Complexity**
O(n log n)

## :round_pushpin: **Logic**
1. 귤 크기별 개수를 map으로 센다.
2. 크기별 개수만 추출해서 리스트로 만들고, 내림차순 정렬
3. 가장 많이 등장한 크기부터 차례대로 선택
4. 누적 개수가 `k` 이상이 되면 종료
5. 선택한 귤 종류(크기) 개수 반환


## :black_nib: **Review** 
첨 봤을 때 감을 잡진 못함 바보

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/138476
