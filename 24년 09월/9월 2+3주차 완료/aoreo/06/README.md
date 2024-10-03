# [백준 - 실버1] 2583.영역 구하기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
BFS

## :round_pushpin: **Logic**
1. M*N 크기의 배열에서 네모가 포함되는 영역을 true로 처리
2. 이중 for문으로 모든 영역을 탐색하며, 방문한 적 없으며, maps에서 false인 경우만 탐색
3. queue에 add할 경우, 영역 사이즈를 의미하는 areaSize의 값을 1 증가
4. 처음 queue를 생성할 때마다, 영역의 개수를 나타내는 areaCnt의 값을 1 증가

## :black_nib: **Review**
왼쪽 하단 점은 포함되나, 오른쪽 상단 점은 범위에 포함되지 않아야 한다는 점에서 좀 꼬였었다 

## 📡 Link
https://www.acmicpc.net/problem/2583
