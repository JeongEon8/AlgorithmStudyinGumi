# [백준 - S1] 2615. 오목
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- 6목이면 안되므로 현재 위치를 기준으로 왼쪽/오른쪽을 모두 탐색해야 함
- 가장 왼쪽에 있는 바둑알(열의 위치가 같다면 가장 위에 있는 바둑알)을 출력해야 함
  - 이중 for문의 인덱스를 변경해서 열을 먼저 살펴보도록 하기
```java
for (int j = 0; j < N; j++) {
  for (int i = 0; i < N; i++) {
    if (map[i][j] != 0) {
      if (checkRow(i, j, map[i][j]) || checkCol(i, j, map[i][j]) || checkLCross(i, j, map[i][j])
          || checkRCross(i, j, map[i][j])) {
        System.out.println(map[i][j]);
        System.out.println((i + 1) + " " + (j + 1));
        return;
      }
    }
  }
}
```

## :black_nib: **Review**
조건을 잘 읽었으면 한 번에 통과했을텐데 한 조건을 빼뜨려서 2번 정도 틀린 후에 맞았다ㅎㅎ..

## 📡**Link**
- https://www.acmicpc.net/problem/2615
