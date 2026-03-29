# [백준 - S4] 9290. 틱택토 이기기


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
각 빈칸마다 체크를 하고 이겼는지 확인을한다.
```java
char[][] board = new char[3][3];
for (int i = 0; i < 3; i++) {
    board[i] = in.readLine().toCharArray();
}
char ox = in.readLine().charAt(0);
boolean isFinish = false;
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
            board[i][j] = ox;
            if (isWin(board, ox)) {
                isFinish = true;
                break;
            }
            board[i][j] = '-';
        }
    }
    if (isFinish)
        break;
}

sb.append("Case ").append(tc).append(": \n");
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        sb.append(board[i][j]);
    }
    sb.append('\n');
}

```

## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/9290