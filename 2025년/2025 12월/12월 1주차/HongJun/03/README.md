# [백준 - G5] 1068. 트리

## ⏰ **time**
40분

## :pushpin: **Algorithm**
- 그래프, DFS, 트리

## ⏲️**Time Complexity**
$O(v+e)$

## :round_pushpin: **Logic**
- DFS 재귀 코드에서 탐색할 노드가 삭제하려는 노드 K이면 -1을 리턴한다
- 해당 노드가 자식이 없는 리프 노드이면 리프 노드를 카운팅하는 변수에 +1을 한다
- 노드를 dfs 탐색으로 봤을 때, 자식 노드가 k이고, 현재 노드의 자식 수가 1이면 리프 노드가 된다

 
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/1068