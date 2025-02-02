# [백준 - G4] 11404. 플로이드

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 최단 거리

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**
- 2차원 배열에서 x, y가 같은 곳은 0으로, 나머지는 최댓값으로 초기설정
- 3중 for문을 돌면서 '[i][k] + [k][j]'와 최솟값 비교해서 갱신

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11404