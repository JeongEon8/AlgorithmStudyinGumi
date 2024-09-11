# [백준 G4] 1987. 알파벳

## ⏰ **소요 시간**

30분

## :pushpin: **Algorithm**

DFS, 백트래킹

## ⏲️**Time Complexity (시간 복잡도)**

$O(N)$

## :round_pushpin: **Logic**

- 시작 지점인 (0, 0)에서 4방향으로 DFS 탐색을 한다.
- 탐색한 알파벳을 넣는 배열을 set으로 해서 중복 알파벳이 들어가지 않게 한다.
- 다음 탐색할 노드를 다시 DFS 돌린다.
- DFS가 끝나면 알파벳을 빼준다.

## :black_nib: **Review**

- 기본적인 백트래킹 문제인데 아직 DFS 사용하는게 익숙하지 않은 듯 하다.

## 📡 Link

https://www.acmicpc.net/problem/1987
