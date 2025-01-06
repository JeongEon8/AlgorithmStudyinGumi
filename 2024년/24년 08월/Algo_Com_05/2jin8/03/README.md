# [SWEA - SW Test 샘플문제] 1767. 프로세서 연결하기
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
완전 탐색

## :round_pushpin: **Logic**
- N이 최대 12 & 코어의 최대 개수도 12 ⇒ 완전 탐색 가능!
- 최대한 많은 코어를 연결하는 것이므로 다음과 같이 나눠서 탐색하기
  - 해당 코어에 전원 연결 O (네 방향 탐색)
    - 해당 방향에 다른 코어나 전선이 있는지 확인하기
  - 해당 코어에 전원 연결 X
```java
static void dfs(int depth, int core, int len) {
  // 남은 코어의 개수를 다 연결해도 최대 코어 개수보다 작으면 더 이상 연결할 필요가 없음..!
  // 남은 코어의 개수: coreList.size() - depth
  // 현재까지 연결한 코어의 개수: core
  if (coreList.size() - depth + core < maxCore)
    return;

  if (depth == coreList.size()) {
    if (maxCore < core) {
      maxCore = core;
      minLen = len; // 길이도 갱신해야 함..! 
    } else if (maxCore == core) { // 코어 개수가 같을 때도 고려해야 함..!
      minLen = Math.min(minLen, len);
    }
    return;
  }

  Point point = coreList.get(depth);
  int x = point.x, y = point.y;
  // 가장자리에 위치한 core는 이미 전원이 연결되므로 다음 core로 넘어가기
  if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
    dfs(depth + 1, core + 1, len);
    return;
  }

  // 네 방향 탐색 (해당 core 선택)
  for (int i = 0; i < 4; i++) {
    // 해당 방향으로 전선을 놓을 수 있는 경우
    if (check(x, y, i)) {
      // 값 변경 & 재귀
      int nowCnt = changeArray(x, y, i, 2);

      dfs(depth + 1, core + 1, len + nowCnt);
      changeArray(x, y, i, 0); // 검사해서 옆이 다 0이였으니까 0으로 초기화해도 되는 것..
    }
  }

  // 해당 core 선택 X
  dfs(depth + 1, core, len);
}
```

## :black_nib: **Review**
행 복사, 열 복사 방법에 대해 쓸데없이 머리를 굴리느라 시간을 버렸다. 하나의 반복문에서 행, 열을 확인해야 할 때는 while 문과 dx, dy 값을 방법을 외워야 할 듯.
또한 값을 갱신할 때 두 개의 조건을 고려해야 했는데, 이런 경험은 처음이라 조건을 제대로 고려하지 못하고 작성했다. 조건을 잘 정리하는 습관을 들여놓자..!

## 📡**Link**
- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
