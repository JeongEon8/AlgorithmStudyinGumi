# [백준 - 실버1] 1986.체스
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
1. 나이트가 움직일 수 있는 경로를 kx, ky로 나타냄, 퀸이 움직일 수 있는 경로를 qx, qy로 나타냄.
2. cnt로 안전하지 않은 칸 수 셈
3. N*M의 int형 배열을 생성하여, queen이면 1, knight면 2, pawn이면 3, 확인하지 않았거나 안전하면 0, 안전하지 않다면 -1로 저장
4. 퀸은 장애물이 나타나기 전까지 한 방향으로 쭉 갈 수 있으므로, 8가지 방향을, 장애물이 나타나거나, 판을 벗어날 때까지 확인하며 안전하지 않은 칸 확인
5. 나이트가 움직이는 경로를 확인하며 안전하지 않은 칸 확인, 안전하지 않다면 -1로 변경
6. N*M에서 안전하지 않은 칸의 수(cnt 값), 퀸 개수, 나이트 개수, 폰 개수를 뺀 값을 반환

## :black_nib: **Review**
문제만 잘 따라가면 됐던 문제였다.
그래서 알고리즘 분류도 그냥 구현인듯?

## 📡 Link
https://www.acmicpc.net/problem/1986
