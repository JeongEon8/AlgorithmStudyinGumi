# [백준 - 실버 3] 2606. 바이러스
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 입력한 노드들은 연결된 노드들이니까 2차원 배열에서 해당 인덱스에 둘 다 추가해준다.
- dfs를 돌린다.
- 방문체크가 안된 곳이 있으면 재귀로 DFS 함수를 실행한다.
- 함수가 종료되면 방문된 노드들의 개수를 출력한다.

## :black_nib: **Review**
- 재귀 어려워...

## 📡 Link
https://www.acmicpc.net/problem/2606
