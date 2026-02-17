# [백준 - S3] 1063. 킹

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 각 명령어는 `(dx, dy)` 벡터로 변환시켜 이동

    | 명령 | dx | dy |
    | -- | -- | -- |
    | R  | +1 | 0  |
    | L  | -1 | 0  |
    | B  | 0  | -1 |
    | T  | 0  | +1 |
    | RT | +1 | +1 |
    | LT | -1 | +1 |
    | RB | +1 | -1 |
    | LB | -1 | -1 |

1. 왕의 다음 위치 계산 후, 체스판 밖으로 나가면 이동을 무시한다.
1. 왕과 돌의 위치가 겹치는 경우, 돌을 왕이 이동하는 방향으로 한칸 민다.

```java
// 킹의 다음 위치
int nextKingX = kingX + dx;
int nextKingY = kingY + dy;

// 킹이 범위 밖이면 무시
if (nextKingX < 0 || nextKingX >= 8 || nextKingY < 0 || nextKingY >= 8)
    continue;

// 킹이 돌과 같은 위치로 이동하는 경우
if (nextKingX == stoneX && nextKingY == stoneY) {

    int nextStoneX = stoneX + dx;
    int nextStoneY = stoneY + dy;

    // 돌이 범위 밖이면 이동 무시
    if (nextStoneX < 0 || nextStoneX >= 8 || nextStoneY < 0 || nextStoneY >= 8)
        continue;

    // 돌 이동
    stoneX = nextStoneX;
    stoneY = nextStoneY;
}

// 킹 이동
kingX = nextKingX;
kingY = nextKingY;

```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/1063](https://www.acmicpc.net/problem/1063)
