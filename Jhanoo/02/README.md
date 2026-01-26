# [백준 - G4] 2239. 스도쿠

## ⏰**time**

65분

## :pushpin: **Algorithm**

백트래킹(DFS) + 비트마스크

## ⏲️**Time Complexity**

$O(9^m)$ (m = 빈 칸의 개수, 최대 81).

## :round_pushpin: **Logic**

1. 9×9 보드를 입력받으며, 빈 칸(0)의 행·열 인덱스를 `blankRow`, `blankCol`에 저장한다.
2. 채워진 칸은 `rowMask`, `colMask`, `boxMask`에 비트로 표시한다.  
   `box(r, c) = (r/3)*3 + (c/3)` 로 3×3 영역 인덱스를 구한다.
3. DFS로 빈 칸을 순서대로 채운다.
   - `used = rowMask[r] | colMask[c] | boxMask[b]` 로 해당 행·열·박스에 이미 쓰인 숫자를 구한다.
   - `cand = (~used) & 0b111111111` 로 넣을 수 있는 숫자 후보(비트)를 구한다.
   - `cand & -cand`(lowbit)로 후보를 하나씩 꺼내고, `Integer.numberOfTrailingZeros(bit) + 1`로 실제 숫자(1~9)를 얻는다.
   - 숫자를 넣고 마스크를 XOR로 갱신한 뒤 재귀, 실패 시 원상복구(다시 XOR) 후 다음 후보 시도.
4. `idx == blankCnt`에 도달하면 한 가지 해를 찾은 것이므로 `solved = true`로 설정하고 모든 재귀를 종료한다.
5. 최종 보드를 한 줄에 9자씩 9줄로 출력한다.

   ```
   빈 칸 목록으로 DFS → 각 칸에서 used/cand 비트마스크로 후보 추출
   → lowbit 순회로 작은 수부터 시도, 백트래킹
   ```

## :black_nib: **Review**

- 비트마스크로 행·열·박스 사용 숫자를 빠르게 관리하고, 후보 추출·순회까지 비트 연산으로 처리해 코드가 간결하고 효율적이다.

## 📡 Link

https://www.acmicpc.net/problem/2239
