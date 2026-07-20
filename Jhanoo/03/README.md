# [PGS - Lv2] 03_삼각 달팽이

## ⏰**time**

18분

## :pushpin: **Algorithm**

- 시뮬레이션
- 2차원 배열
- 방향 배열
- 구현

## ⏲️**Time Complexity**

$O(N^2)$
삼각형에 채워지는 전체 숫자 개수는 다음과 같다.

```text
1 + 2 + 3 + ... + N = N(N + 1) / 2
```

각 위치에 숫자를 한 번씩 채우고, 완성된 삼각형을 다시 한 번 순회해 정답 배열로 옮기므로 전체 시간 복잡도는 $O(N^2)$이다.

## :round_pushpin: **Logic**

1. 삼각형 모양을 표현하기 위해 `N x N` 크기의 2차원 배열을 만든다.

   실제로는 각 행에서 `0`부터 해당 행 번호까지의 영역만 사용한다.

   ```java
   int[][] a = new int[n][n];
   ```

2. 삼각 달팽이는 다음 세 방향을 반복하며 숫자를 채운다.

   ```text
   아래
   오른쪽
   왼쪽 위
   ```

   이를 방향 배열로 표현한다.

   ```java
   int[] dr = {1, 0, -1};
   int[] dc = {0, 1, -1};
   ```

3. 첫 이동이 아래쪽이므로 시작 좌표를 배열 바로 위쪽인 `(-1, 0)`으로 설정한다.

   ```java
   int row = -1;
   int col = 0;
   int direction = 0;
   int num = 1;
   ```

4. 각 방향으로 이동하는 횟수는 다음처럼 한 번씩 줄어든다.

   ```text
   N
   N - 1
   N - 2
   ...
   1
   ```

   따라서 `length`를 `N`부터 `1`까지 감소시키며 반복한다.

   ```java
   for (int length = n; length > 0; length--) {
   }
   ```

5. 현재 방향으로 `length`번 이동하면서 좌표를 갱신하고 숫자를 채운다.

   ```java
   for (int i = 0; i < length; i++) {
       row += dr[direction];
       col += dc[direction];
   
       a[row][col] = num++;
   }
   ```

6. 한 방향의 이동이 끝나면 다음 방향으로 변경한다.

   방향은 `아래 → 오른쪽 → 왼쪽 위` 순서로 반복된다.

   ```java
   direction = (direction + 1) % 3;
   ```

7. 정답 배열의 크기는 삼각형에 들어가는 전체 숫자 개수와 같다.

   ```java
   int[] answer = new int[n * (n + 1) / 2];
   ```

8. 완성된 2차원 배열을 위에서부터 행 순서대로 읽는다.

   `i`번째 행에서는 `0`부터 `i`까지의 값만 정답 배열에 저장한다.

   ```java
   int idx = 0;
   
   for (int i = 0; i < n; i++) {
       for (int j = 0; j <= i; j++) {
           answer[idx++] = a[i][j];
       }
   }
   ```

9. 완성된 1차원 배열을 반환한다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

- 이동 방향을 `아래`, `오른쪽`, `왼쪽 위` 세 가지로 정의하고 방향 배열을 사용하니 구현이 간단해졌다.
- 시작 위치를 `(-1, 0)`으로 두면 첫 번째 이동부터 동일한 로직으로 처리할 수 있었다.
- 전체 숫자 개수가 `N(N+1)/2`라는 점을 이용해 정답 배열의 크기를 미리 계산했다.
- 각 숫자를 한 번씩 채우고 다시 한 번 읽기 때문에 전체 시간 복잡도는 $O(N^2)$이다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/68645
