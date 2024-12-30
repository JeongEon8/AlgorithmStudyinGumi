# [프로그래머스 - LV.2] 카펫
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(√n)$

## :round_pushpin: **Logic**
노란색 영역을 기준으로 계산하는 게 편하기 때문에 노란색 영역에 집중!
1. 가로 길이가 세로 길이보다 크므로 세로 길이인 cnt가 가로 길이인 yellow/cnt보다 작을 때까지만 진행
2. 가로 길이인 yellow/cnt가 정수이고, 전체 카펫의 세로 길이인 (cnt+2) * 전체 카펫의 가로 길이인 ((yellow/cnt) + 2)가 yellow + brown일 경우, 정답 반환
3. cnt를 1씩 늘려가며 탐색.

## :black_nib: **Review**
- 계산만 하면 쉬운 문제 조아요...

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/42842
