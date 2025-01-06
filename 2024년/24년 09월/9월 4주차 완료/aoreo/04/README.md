# [백준 - 골드5] 2251.물통

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BFS, 우선순위큐

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. a -> b, b -> a, a -> c, c -> a, b -> c, c -> b 옮기는 모든 경우를 탐색
2. 다 옮길 경우, 다 옮기지 못할 경우도 나눠서 queue에 더함
3. a가 빌 경우, pQueue에 bucket C의 양을 추가함
4. priority queue를 통해 작은 값부터 출력

## :black_nib: **Review**
가짓수가 많아서 좀 헷갈렸는데 찬찬히 하면 쉬운 문제였다

## 📡 Link
https://www.acmicpc.net/problem/2251
