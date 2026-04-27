# [백준 - 실버 3] 1063. 킹

## ⏰**time**
10분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 체스판은 8×8이므로 좌표를 0~7 범위로 변환해서 관리한다.
   * 열(A~H) → `y = 문자 - 'A'`
   * 행(1~8) → `x = '8' - 문자` (위에서 아래로 증가하도록 변환)
2. 이동 명령 8가지(`R, L, B, T, RT, LT, RB, LB`)를 방향 인덱스로 매핑하고,
   `dx, dy`로 한 칸 이동을 표현한다.
3. 매 명령마다:
   * 킹이 이동할 다음 칸 `(kmx, kmy)`를 계산
   * 킹이 체스판 밖으로 나가면 무시(continue)
   * 다음 칸에 돌이 있으면 돌도 같은 방향으로 한 칸 밀어야 함
     * 돌이 밖으로 나가면 이번 이동 전체 무시
     * 가능하면 돌 좌표 갱신 후 킹 좌표 갱신
   * 돌이 없으면 킹 좌표만 갱신
4. 모든 명령 수행 후 좌표를 다시 체스 표기(A1~H8)로 변환해 출력한다.

```
입력 좌표 → (x, y)로 변환

for each command:
    dir 결정
    nextK = K + (dx[dir], dy[dir])

    if nextK out of board: continue

    if nextK == Stone:
        nextS = Stone + (dx[dir], dy[dir])
        if nextS out of board: continue
        Stone = nextS

    King = nextK

출력: (char)(y+'A'), 8-x
```

## :black_nib: **Review**
-

## 📡 Link

[https://www.acmicpc.net/problem/1063](https://www.acmicpc.net/problem/1063)
