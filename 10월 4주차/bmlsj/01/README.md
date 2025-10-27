# [백준 - G5] 7682. 틱택토

## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

아이디어
1. X와 O의 개수 규칙
2. 승리 여부와 개수 일치
3. 동시에 두 명이 승리할 수 없음
4. 승리자가 없으면 판이 가득 차야 함

---

1. X와 O 개수 확인
- 틱택토 규칙: X가 먼저 두므로
    - `X 개수 == O 개수` → O가 마지막으로 둔 상태
    - `X 개수 == O 개수 + 1` → X가 마지막으로 둔 상태
    - 그 외: 불가능 (invalid)

2. 2차원 배열로 변환
- 1차원 char 배열(`arr[9]`)을 3×3 격자(`map[3][3]`)로 변환
- 인덱스 변환: `map[i][j] = arr[i*3 + j]`

3. 승리 조건 확인
- 가로/세로 3칸 연속 확인
- 대각선 3칸 연속 확인
- X와 O 각각 승리 여부를 `xWin`, `oWin`으로 저장

4. 동시 승리 불가
- X와 O가 동시에 3칸 연속일 경우 → 불가능 (invalid)

4. 승리자와 개수 일치 확인
- X 승리 → `X 개수 == O 개수 + 1`
- O 승리 → `X 개수 == O 개수`
- 불일치 시 → 불가능
5. 승리자가 없는 경우
- 게임판이 전부 채워졌는지 확인
- 일부 칸이 비어있으면 → 불가능 (invalid)


```java
static boolean isValid(char[] arr) {

	int xcnt = 0, ocnt = 0;
	for (char c : arr) {
		if (c == 'X')
			xcnt++;
		else if (c == 'O')
			ocnt++;
	}

	if (ocnt > xcnt || xcnt > ocnt + 1)
		return false;

	// 2차원 배열로 변환
	char[][] map = new char[3][3];
	for (int i = 0; i < 9; i++) {
		map[i / 3][i % 3] = arr[i];
	}

	boolean xWin = false, oWin = false;

    // 가로, 세로 체크
    for (int i = 0; i < 3; i++) {
        if (map[i][0]=='X' && map[i][1]=='X' && map[i][2]=='X') xWin=true;
        if (map[0][i]=='X' && map[1][i]=='X' && map[2][i]=='X') xWin=true;
        if (map[i][0]=='O' && map[i][1]=='O' && map[i][2]=='O') oWin=true;
        if (map[0][i]=='O' && map[1][i]=='O' && map[2][i]=='O') oWin=true;
    }

    // 대각선 체크
    if (map[0][0]=='X' && map[1][1]=='X' && map[2][2]=='X') xWin=true;
    if (map[0][2]=='X' && map[1][1]=='X' && map[2][0]=='X') xWin=true;
    if (map[0][0]=='O' && map[1][1]=='O' && map[2][2]=='O') oWin=true;
    if (map[0][2]=='O' && map[1][1]=='O' && map[2][0]=='O') oWin=true;
        
    // X와 O가 동시에 승리하면 invalid
    if (xWin && oWin) return false;

    // 승리자와 개수 체크
    if (xWin && xcnt != ocnt + 1) return false;
    if (oWin && xcnt != ocnt) return false;

    // 승리자가 없으면 마지막까지 채워졌는지 확인
    if (!xWin && !oWin && xcnt + ocnt != 9) return false;
        
	return true;
}
```

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/7682
