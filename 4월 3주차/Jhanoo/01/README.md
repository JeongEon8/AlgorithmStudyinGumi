# [프로그래머스 - Lv3] 퍼즐 조각 채우기

## ⏰**time**

74분

## :pushpin: **Algorithm**

- BFS
- 구현
- 도형 정규화 (Normalization)
- 회전 비교

## ⏲️**Time Complexity**

$O(N^4)$ (최악 기준)

## :round_pushpin: **Logic**

1. `game_board`에서 값이 `0`인 빈칸 도형들, `table`에서 값이 `1`인 퍼즐 도형들을 각각 BFS로 추출합니다.

```java
if (!visitedBoard[i][j] && game_board[i][j] == 0) {
    blanks.add(getShape(game_board, visitedBoard, i, j, 0));
}
if (!visitedTable[i][j] && table[i][j] == 1) {
    pieces.add(getShape(table, visitedTable, i, j, 1));
}
```

2. 추출한 도형은 좌표를 그대로 두지 않고, 가장 왼쪽 위를 `(0, 0)`으로 맞추는 정규화를 수행합니다.  
   정규화 후 좌표를 정렬해두면 도형 동치 비교가 쉬워집니다.

```java
for (int[] p : shape) {
    normalized.add(new int[]{p[0] - minX, p[1] - minY});
}
normalized.sort((a, b) -> {
    if (a[0] == b[0]) return a[1] - b[1];
    return a[0] - b[0];
});
```

3. 각 빈칸 도형에 대해 아직 사용하지 않은 퍼즐 도형을 순회하며, 크기가 같을 때만 비교합니다.  
   퍼즐 도형을 최대 4번(90도씩) 회전시키며 빈칸과 같은지 검사합니다.

```java
for (int r = 0; r < 4; r++) {
    piece = rotate(piece);
    if (isSame(blank, piece)) {
        used[i] = true;
        answer += blank.size();
        break;
    }
}
```

4. 매칭이 성립한 퍼즐은 재사용되지 않도록 `used`로 관리하고, 채운 칸 수(`blank.size()`)를 누적해 최종 정답을 반환합니다.

## :black_nib: **Review**

- 어렵다... 백준은 이제 없어..

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/84021
