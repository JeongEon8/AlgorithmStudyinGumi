# [SWEA - D3️] 1873. 상호의 배틀필드
 
## ⏰  **time**
35분

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- 이동해야 하는 경우 → 방향을 변경하기
  - 1칸 앞이 평지라면 한 칸 앞으로 이동하기 & 전차의 위치 갱신하기
- 포탄을 쏴야 하는 경우 → 포탄을 쏘는 방향 정하기
  - 포탄의 위치를 이동하기
  - 포탄이 위치한 곳이 벽돌 벽이라면 부수기 (평지로 변경)
  - 포탄이 위치한 곳이 강철 벽이거나 범위를 벗어나면 아무런 일도 일어나지 않음 (반복문 탈출)
```java
// 포탄 쏘기
static void shoot(int dx, int dy) {
  int sx = x, sy = y;
  while (true) {
    sx += dx;
    sy += dy;

    // 범위를 벗어나면 종료
    if (sx < 0 || sy < 0 || sx >= H || sy >= W)
      break;

    if (map[sx][sy] == '*') { // 부딪힌 곳이 벽돌 벽이라면 부숴짐
      map[sx][sy] = '.';
      break;
    } else if (map[sx][sy] == '#') { // 부딪힌 곳이 강철 벽이라면 아무일도 일어나지 않음
      break;
    }
  }
}
```

## :black_nib: **Review**
다행히도 문제에서 주어진대로 구현만 하면 되는 문제였다. 처음에는 겹치는 코드가 많았는데 GPT의 도움을 받아 공통 부분을 메서드로 뺄 수 있었다. 
사람들이 왜 GPT를 사용하는지 알 수 있었다... 굿

## 📡**Link**
- [SWEA 1873. 상호의 배틀필드](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc)
