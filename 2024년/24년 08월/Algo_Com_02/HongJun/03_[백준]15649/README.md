# [백준 - 실버3] 15649. N과 M (1)
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
백트래킹, 부분 수열

## ⏲️**Time Complexity**
$O(N * N)$

## :round_pushpin: **Logic**
1부터 N까지의 수열에서 길이가 M인 부분 수열을 모두 구하는 문제.


- 재귀를 돌리는 함수에 파라미터로 수열의 길이를 넣고 함수를 호출할 때는 0부터 시작한다.
- 그럼 0 -> 1 -> 2 ... 이렇게 수열의 길이가 1씩 늘어나고 M이 됐을 때 return하면 된다.
- 결과값 배열에 탐색한 숫자를 추가하고, 재귀를 돌리고, 다시 빼주는 식으로 반복한다.

## :black_nib: **Review**
백트래킹 화이팅!


## 📡 Link
https://www.acmicpc.net/problem/15649