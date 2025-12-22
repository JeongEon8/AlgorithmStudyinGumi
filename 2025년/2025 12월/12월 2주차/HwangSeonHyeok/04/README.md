# [백준 - S5] 12759. 틱! 택! 토!

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션
- 많은 조건 분기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
놓을 때마다 해당 칸을 플레이어 번호로 채우고 틱텍토에서 승리 조건을 확인한다.  
가로, 세로, 대각선이 가능한 경우는 그 대각선도 확인한다.
```java
for (int i = 0; i < 9; i++) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    board[y][x] = currentPlayer;
    if (board[y][1] == board[y][2] && board[y][2] == board[y][3]) {
        ans = currentPlayer;
    }
    if (board[1][x] == board[2][x] && board[2][x] == board[3][x]) {
        ans = currentPlayer;
    }
    if (y == x) {
        if (board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
            ans = currentPlayer;
        }
    }
    if (y + x == 4) {
        if (board[1][3] == board[2][2] && board[2][2] == board[3][1]) {
            ans = currentPlayer;
        }
    }

    if (ans != 0)
        break;
    currentPlayer = currentPlayer % 2 + 1;
}
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/12759