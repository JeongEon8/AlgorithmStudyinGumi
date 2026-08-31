# [PGS - lv2] 02\_혼자서 하는 틱택토

## ⏰**time**

40분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

- 틱택토가 성공할 수 없는 경우를 모두 제거해준다.
  1. O가 X보다 작은 경우
  2. O가 X + 1보다 훨씬 큰 경우
  3. 이긴 경우를 체크
  - O가 이겼는데, O의 갯수가 X + 1이 아닌 경우
  - X가 이겼는데, O와 X의 갯수가 같지 않은 경우

```java
if (oCnt < xCnt || oCnt > xCnt + 1) return 0;

boolean oWins = isWinner(board, 'O');
boolean xWins = isWinner(board, 'X');

if (oWins && oCnt != xCnt + 1) return 0;
if (xWins && oCnt != xCnt) return 0;
```

## :black_nib: **Review**

- 증빤새 가지마

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/160585>
