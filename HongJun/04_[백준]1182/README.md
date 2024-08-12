# [백준 - 실버2] 1182. 부분수열의 합
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
백트래킹, 재귀

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
수열의 합이 S가 되는 모든 경우의 수를 구하는 문제.
- 백트래킹 재귀로 수열에 현재 탐색하는 숫자를 포함하는 경우와 포함하지 않는 경우 2가지를 재귀 돌려야한다.
- 수열의 합이 S가 된 경우 출력값에 +1을 해준다.
- 함수가 종료되는 조건은 수열의 길이가 N이상일 때 return한다.


## :black_nib: **Review**
백트래킹, 재귀 연습 더 많이 해야겠다...

## 📡 Link
https://www.acmicpc.net/problem/1182