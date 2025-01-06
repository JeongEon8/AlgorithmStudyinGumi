# [백준 G5] 13549. 숨바꼭질3
 
## ⏰  **소요 시간**
30분

## :pushpin: **Algorithm**
최단경로, 다익스트라

## ⏲️**Time Complexity (시간 복잡도)**
$O(N logN)$

## :round_pushpin: **Logic**
- 백트래킹으로 풀 수 있던 문제였다.
- 다익스트라를 적용할 수 있어서 다익스트라로 생각해봤다.
- 이동할 수 있는 위치 3방향과 비용을 쌍으로 묶어서 저장한다.
- 도착 위치가 범위를 벗어나면 안되기 때문에 조건문을 달아준다.
- 더 적은 비용을 계속 갱신해준다.

## :black_nib: **Review**
다익스트라 어렵다 ㅠㅠ

## 📡 Link
https://www.acmicpc.net/problem/13549