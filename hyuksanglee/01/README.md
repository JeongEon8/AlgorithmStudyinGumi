# [백준 - G2] 3109. 빵집
 
## ⏰  **time**
1시간 30븐

## :pushpin: **Algorithm**
그리디 + 완탐

## :round_pushpin: **Logic**
- 왼쪽 열에서 오른쪽 열까지 이어지는 파이프 라인의 개수가 최대가 되려면 제일 윗 칸부터 연결되도록 해야 함 (그리디적 사고)
  - 따라서 방향을 ↗ → ↘ 순서대로 탐색하기
```java
static void dfs(int x, int y) {
  // 해당 행에서 파이프 라인 경로를 찾은 경우
  if (find) {
    return;
  }

  // 마지막 열에 도착한 경우
  if (y == C - 1) {
    cnt++;
    find = true;
    return;
  }

  for (int i = 0; i < 3; i++) {
    int nx = x + dx[i];
    int ny = y + 1;
    if (nx < 0 || nx >= R || ny >= C)
      continue;

    if (map[nx][ny] == '.') {
      map[nx][ny] = 'x';
      dfs(nx, ny);
      if (find) return; // 꼭 필요함! 이게 없으면 이동할 수 있는 칸을 쓸데없이 방문 처리함
    }
  }
}
```

## :black_nib: **Review**
단순하게 제일 윗 칸부터 채워 나가야겠다는 생각은 했지만 코드를 제출하면 답이 틀렸었다. 풀이를 참고하니 dfs 메소드 내의 로직이 완전 틀렸었다.. 생각과 풀이 로직을 잘 생각한 뒤에 코드를 작성하는 습관을 들여야 할 것 같다.

## 📡**Link**
- https://www.acmicpc.net/problem/3109
