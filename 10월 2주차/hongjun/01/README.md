# [백준 G4] 9663. N-Queen

## ⏰ **소요 시간**
50분

## :pushpin: **Algorithm**

백트래킹, 브루트포스

## ⏲️**Time Complexity (시간 복잡도)**

$O(N)$

## :round_pushpin: **Logic**

1. 표시되지 않은 곳에 말을 놓고 가로, 세로, 양쪽 대각선에 해당하는 위치에 전부 표시를 해준다.
2. 대각선 두개는 i+j가 모두 같거나 i-j가 모두 같은 경우이다.
3. 둘 수 없는 곳에 표시를 하고 백트래킹으로 다른 위치도 확인한다.
4. 빠져나오고 나서는 다시 원상복구해준다.

## :black_nib: **Review**
백트래킹 어렵다...

## 📡 Link

https://www.acmicpc.net/problem/9663
