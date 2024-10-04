# [백준 - G4] 2239. 스도쿠
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(9ⁿ)$ (n: 빈 칸의 수)

## :round_pushpin: **Logic**
- 빈 칸에 1~9 사이의 숫자를 하나씩 대입
- 스도쿠 조건에 맞으면 다음 빈 칸으로 넘어가고, 조건에 맞지 않으면 다른 숫자 넣기 (백트래킹)
```java
static void dfs(int depth) {
  if (isFind) { // 이미 답을 채웠다면 끝내기
    return;
  }
  
  if (depth == list.size()) { // 빈 칸을 다 채우면 탐색 종료
    isFind = true;
    return;
  }

  Pos now = list.get(depth);
  int x = now.x, y = now.y;
  for (int i = 1; i <= N; i++) {
    if (checkRow(x, i) && checkCol(y, i) && checkSquare(x, y, i)) {
      arr[x][y] = i;
      dfs(depth + 1);
      if (isFind)
        break;
      arr[x][y] = 0;
    }
  }
}

// 가로 확인
static boolean checkRow(int x, int num) {
  for (int i = 0; i < N; i++) {
    if (arr[x][i] == num)
      return false;
  }
  return true;
}

// 세로 확인
static boolean checkCol(int y, int num) {
  for (int i = 0; i < N; i++) {
    if (arr[i][y] == num)
      return false;
  }
  return true;
}

// 3 * 3 사각형 확인
static boolean checkSquare(int x, int y, int num) {
  int sx = x / 3 * 3, sy = y / 3 * 3, ex = sx + 3, ey = sy + 3;
  for (int i = sx; i < ex; i++) {
    for (int j = sy; j < ey; j++) {
      if (arr[i][j] == num)
        return false;
    }
  }
  return true;
}
```

## :black_nib: **Review**
스도쿠 특성상 빈 칸이 적절히 주어지기 때문에 완탐으로 풀릴 것 같아 완탐으로 풀었다. 

## 📡**Link**
- https://www.acmicpc.net/problem/2239
