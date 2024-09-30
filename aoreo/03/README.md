# [백준 - 실버1] 3184.양

## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^4)$

## :round_pushpin: **Logic**
1. 방문한 적 없고 '#'이 아닐 경우 한 영역 탐색 시작
2. 사방향을 탐색하며, 방문한 적 없고, '#'이 아닐 경우, queue에 추가하고, 'o'일 경우 양의 수 +1, 'v'일 경우 늑대의 수 +1
3. 양의 수가 더 많을 경우 최종 양의 수에 sCnt를 더하고, 늑대의 수가 더 많거나 같을 경우 최종 늑대의 수에 wCnt를 더함

## :black_nib: **Review**
전형적인 bfs 문제였당

## 📡 Link
https://www.acmicpc.net/problem/3184
