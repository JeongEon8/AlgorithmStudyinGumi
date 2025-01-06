# [백준 - 실버1] 5014.스타트링크
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## :round_pushpin: **Logic**
1. 시작층(S)를 queue에 저장
2. G에 도달할 때까지 현재점+U가 방문한 적 없으며, 범위에 해당할 경우 queue에 추가하고 방문처리
3. 현재점-D가 방문한 적 없으며, 범위에 해당할 경우 queue에 추가하고 방문처리
4. visited[G]를 answer로 저장하여 반환하며, 시작 시에 1로 시작했으므로 1 감소, 해당 값이 0일 경우 도달한 적 없다는 의미이므로 "use the stairs" 반환

## :black_nib: **Review**
다른 알고리즘으로 풀려고 하다가 BFS로 해봤는데 통과하넹 개꿀

## 📡 Link
https://www.acmicpc.net/problem/5014
