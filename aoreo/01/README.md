# [백준 - 골드5] 14503. 로봇 청소기
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 사방향 탐색하며 청소할 수 있는 곳 찾기
2. 청소할 수 있다면, queue에 추가하고 visited 업데이트하고 방향 변경
3. 청소할 수 없다면, 반대방향을 이동할 수 있는지 확인하고, 이동할 수 있다면 queue에 넣고, visited를 업데이트
4. 이동할 수 없다면, queue 빠져나오기

## :black_nib: **Review**
문제를 제대로 이해못하고, 자꾸 방향 헷갈려서 오래걸렸다ㅠㅠ

## 📡 Link
https://www.acmicpc.net/problem/14503
