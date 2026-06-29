# [PGS - Lv2] 03_[1차] 프렌즈4블록

## ⏰**time**

56분

## :pushpin: **Algorithm**

- 시뮬레이션
- 구현
- 2차원 배열
- 완전 탐색

## ⏲️**Time Complexity**

$O(K \times M \times N)$
`M`은 행의 개수, `N`은 열의 개수, `K`는 블록 제거가 반복되는 라운드 수이다.

한 라운드에서 제거할 2 x 2 블록을 찾는 과정은 $O(M \times N)$이다.
제거된 블록을 아래로 내리는 과정도 각 열을 한 번씩만 순회하므로 $O(M \times N)$이다.

따라서 전체 시간 복잡도는 $O(K \times M \times N)$이다.

## :round_pushpin: **Logic**

1. 입력으로 주어진 `String[] board`는 문자열이므로 문자를 직접 수정할 수 없다.

   따라서 각 행을 `char[]`로 변환해 `char[][] boards`로 만든다.

   ```java
   char[][] boards = new char[m][];
   
   for (int i = 0; i < m; i++) {
       boards[i] = board[i].toCharArray();
   }
   ```

2. 블록 제거와 아래로 당기기를 더 이상 제거할 블록이 없을 때까지 반복한다.

   한 라운드에서 제거한 블록 수가 `0`이면 반복을 종료한다.

   ```java
   while (true) {
       int removes = remove(m, n, boards);
   
       if (removes == 0) break;
   
       pullDown(m, n, boards);
       cnt += removes;
   }
   ```

3. `remove()`에서는 현재 보드에서 제거할 수 있는 2 x 2 블록을 찾는다.

   제거 여부를 바로 보드에 반영하면 아직 검사하지 않은 다른 2 x 2 영역에 영향을 줄 수 있으므로, 먼저 `boolean[][] removed`에 표시한다.

   ```java
   boolean[][] removed = new boolean[m][n];
   ```

4. 모든 위치 `(i, j)`를 기준으로 오른쪽, 아래쪽, 오른쪽 아래까지 같은 문자인지 확인한다.

   이미 제거된 칸은 공백 문자 `' '`로 표시하므로 검사에서 제외한다.

   ```java
   char cur = boards[i][j];
   
   if (cur == ' ') 
       continue;
   
   if (cur != boards[i][j + 1]) 
       continue;
   if (cur != boards[i + 1][j]) 
       continue;
   if (cur != boards[i + 1][j + 1]) 
       continue;
   ```

5. 2 x 2 블록이 모두 같은 문자라면 해당 네 칸을 제거 대상으로 표시한다.

   여러 2 x 2 블록이 겹칠 수 있으므로, 실제 제거는 모든 검사가 끝난 뒤 한 번에 수행한다.

   ```java
   removed[i][j] = true;
   removed[i][j + 1] = true;
   removed[i + 1][j] = true;
   removed[i + 1][j + 1] = true;
   ```

6. 모든 검사가 끝난 뒤 `removed`가 `true`인 칸을 실제로 제거한다.

   제거된 칸은 공백 문자 `' '`로 표시하고, 제거한 개수를 센다.

   ```java
   int cnt = 0;
   
   for (int i = m - 1; i >= 0; i--) {
       for (int j = 0; j < n; j++) {
           if (removed[i][j]) {
               boards[i][j] = ' ';
               cnt++;
           }
       }
   }
   
   return cnt;
   ```

7. `pullDown()`에서는 각 열을 아래에서 위로 확인하면서 빈칸 개수를 센다.

   `blanks`는 현재 위치 아래쪽에 존재하는 빈칸의 개수를 의미한다.

   ```java
   for (int j = 0; j < n; j++) {
       int blanks = 0;
   
       for (int i = m - 1; i >= 0; i--) {
           if (boards[i][j] == ' ') {
               blanks++;
           }
       }
   }
   ```

8. 블록을 만났을 때 아래쪽에 빈칸이 있다면, 빈칸 개수만큼 아래로 내려준다.

   기존 위치는 빈칸으로 바꾼다.

   ```java
   else if (blanks > 0) {
       boards[i + blanks][j] = boards[i][j];
       boards[i][j] = ' ';
   }
   ```

## :black_nib: **Review**

- 문자열 배열은 직접 수정할 수 없기 때문에 `char[][]`로 변환해서 보드를 관리했다.
- 제거할 블록을 찾는 과정에서 바로 공백으로 바꾸면 다른 2 x 2 검사에 영향을 줄 수 있으므로, `boolean[][] removed`에 먼저 표시한 뒤 한 번에 제거했다.
- 블록이 겹쳐서 제거될 수 있기 때문에, 제거 대상 여부를 boolean 배열로 관리하는 것이 중요했다.
- `blanks`는 현재 위치 아래에 있는 빈칸 개수를 의미하고, 블록을 만나면 그 개수만큼 아래로 이동시키는 방식으로 구현했다.
- 제거와 낙하가 반복되는 시뮬레이션 문제이므로, `remove()`와 `pullDown()`을 함수로 분리하니 흐름을 이해하기 쉬웠다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17679
