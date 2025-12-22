# [백준- G4] 3190. 뱀
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- `moveInfo`: 사과를 먹지 못하면 뱀의 꼬리를 이동시켜야 함 → 이때 꼬리의 위치를 갱신하기 위한 용도로 사용
  - `moveInfo[x][y]`: (x, y)에서 어느 방향으로 이동했는지 (== 몸통이 어느 방향으로 향해있는지)
- `change`: 방향 변환을 기록하기 위한 용도로 사용
  - `x`는 최대 10,000 → 해당 길이만큼 배열 생성
  - `change[x]`: x에서 어느 방향으로 이동하는지 기록 (L: -1, R: 1)
```java
while (true) {
    time++;

    // 뱀 머리 이동
    int nextR = headR + dr[dir];
    int nextC = headC + dc[dir];
    // 벽이나 자신의 몸이랑 부딪히면 종료
    if (nextR <= 0 || nextC <= 0 || nextR > N || nextC > N || map[nextR][nextC] == 2)
        break;

    moveInfo[headR][headC] = dir; // 어느 방향으로 이동했는지 기록 (인덱스 에러 주범 - 위치 조심..!)

    // 이동한 칸에 사과가 없는 경우, 꼬리 1칸 없어짐
    if (map[nextR][nextC] == 0) {
        map[tailR][tailC] = 0;
        int tailDir = moveInfo[tailR][tailC];
        tailR += dr[tailDir];
        tailC += dc[tailDir];
    }

    map[nextR][nextC] = 2; // 뱀 머리 이동
    headR = nextR; headC = nextC; // 머리 위치 옮기기

    // 방향 변환 정보가 있는 경우, 방향 전환
    if (change[time] != 0) {
        dir += change[time];
        if (dir < 0) dir = 3;
        if (dir > 3) dir = 0;
    }
}
```

## :black_nib: **Review**
어느 방향으로 기록하는 위치를 잘못 넣어서 인덱스 에러가 났었다.. 생각을 하면서 풀자

## 📡**Link**
- https://www.acmicpc.net/problem/3190
