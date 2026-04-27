# [백준 - G4] 20056. 마법사 상어와 파이어볼

## ⏰  **time**

60분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

- `fires`: 현재 존재하는 모든 파이어볼을 관리하는 리스트
  - 각 파이어볼은 `(r, c, m, s, d)` 형태로 저장
- `map[N][N]`: 한 번의 이동 결과를 임시로 저장하기 위한 2차원 리스트 배열

1. 파이어볼 이동

- 모든 파이어볼을 순회하며 방향 `d`와 속력 `s`에 따라 이동
- 이동 후 좌표는 `mod N` 연산으로 보정
- 이동 결과는 바로 `fires`에 반영하지 않고, `map[r][c]`에 저장

1. 파이어볼 합체 및 분리

- 파이어볼이 1개인 경우: 그대로 다음 상태로 유지
- 파이어볼이 2개 이상인 경우
  - 질량은 `⌊총 질량 / 5⌋`, 속력은 `⌊총 속력 / 개수⌋`
  - 기존 파이어볼의 방향이 모두 홀수 또는 모두 짝수이면 0,2,4,6
      그렇지 않으면 1,3,5,7 방향으로 4개 분리
- 분리 후 질량이 0이면 소멸

1. 상태 갱신

- 한 턴의 처리가 끝나면 기존 fires 리스트를 비우고
   새로 생성된 파이어볼 리스트로 교체
- 위 과정을 `K`번 반복

```java
static void move(List<int[]> fires) {

   for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
         map[i][j].clear();

  for (int i = 0; i < fires.size(); i++) {
      int r = fires.get(i)[0]; // x
      int c = fires.get(i)[1]; // y
      int m = fires.get(i)[2]; // 질량
      int s = fires.get(i)[3]; // 속력
      int d = fires.get(i)[4]; // 방향

      if (d % 2 == 0) {
         r += dxOdd[d / 2] * s % N;
         c += dyOdd[d / 2] * s % N;
      } else {
         r += dxEven[d / 2] * s % N;
         c += dyEven[d / 2] * s % N;
      }

      r = (r + N) % N;
      c = (c + N) % N;

      map[r][c].add(new int[] { r, c, m, s, d });
  }

  List<int[]> newFires = new ArrayList<>();

  for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {

         if (map[i][j].isEmpty())
            continue;

         if (map[i][j].size() == 1) {
            newFires.add(map[i][j].get(0));
         } else {
            splitFire(i, j, newFires);
         }
      }
  }

  fires.clear();
  fires.addAll(newFires);

}

static void splitFire(int x, int y, List<int[]> newFires) {

   int sumM = 0, sumS = 0;
   boolean odd = false, even = false;

   for (int[] f : map[x][y]) {
      sumM += f[2];
      sumS += f[3];
      if (f[4] % 2 == 0)
         even = true;
      else
         odd = true;
   }

   int m = sumM / 5;
   if (m == 0)
      return;

   int s = sumS / map[x][y].size();
   int[] dirs = (odd && even) ? new int[] { 1, 3, 5, 7 } : new int[] { 0, 2, 4, 6 };

   for (int d : dirs) {
      newFires.add(new int[] { x, y, m, s, d });
   }
}
```

## :black_nib: Review

## 📡**Link**

- <https://www.acmicpc.net/problem/20056>
