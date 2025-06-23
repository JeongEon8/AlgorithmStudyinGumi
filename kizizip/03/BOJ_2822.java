# [백준 - S5] 2822. 점수 계산
## ⏰ **time**
20분
## :pushpin: **Algorithm**
- 정렬

## ⏲️**Time Complexity**
O(N log N)

## :round_pushpin: **Logic**
점수, 원래 인덱스를 함께 관리하기 위한 `Integer[] order` <br/>
`Arrays.sort(order, (a, b) -> scores[b] - scores[a])` 점수 기준 내림차순 정렬 <br/>
상위 5개 저장...<br/>
문제 번호를 `Collections.sort()`로 오름차순 정렬하여 출력

## :black_nib: **Review**  
배고파요 
 
## 📡**Link**
https://www.acmicpc.net/problem/2822
