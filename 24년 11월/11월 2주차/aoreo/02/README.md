# [SWEA - D4] 10966. 물놀이를 가자
 
## ⏰  **time**
4시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 물에서부터 시작해서 방문한 적 없는 물일 경우 1로 방문처리를 하고, 해당 지점부터 queue 돌기
2. 사방향 탐색하며 땅이고, 방문한 적 없거나 이전에 방문한 값보다 이제 방문할 값이 더 작으면 값 덮어씌우고 queue에 추가

## :black_nib: **Review**
- 시간초과 엄청 났던 문제...
- 땅에서부터 시작하니까 안되구 물에서부터 시작해도.... 바로는 안됐다 잉

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXWXMZta-PsDFAST
