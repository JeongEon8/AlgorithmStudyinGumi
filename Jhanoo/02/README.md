# [PGS - Lv2] 02_무인도 여행

## ⏰**time**

32분

## :pushpin: **Algorithm**

- BFS
- 그래프 탐색
- 2차원 배열
- 정렬

## ⏲️**Time Complexity**

$O(R \times C + K \log K)$

`R`은 `maps`의 행 개수, `C`는 열 개수, `K`는 발견된 무인도의 개수이다.

BFS를 통해 각 육지 칸을 최대 한 번씩 방문하므로 지도 탐색에는 $O(R \times C)$이 걸린다.

각 무인도에서 구한 식량 합을 리스트에 저장한 뒤 오름차순으로 정렬하므로 $O(K \log K)$이 추가된다.

따라서 전체 시간 복잡도는

```text
O(R × C + K log K)
```

이다.

## :round_pushpin: **Logic**

1. 지도의 행과 열 크기를 구하고, 상하좌우 이동을 위한 방향 배열을 만든다.

   ```java
   rowSize = maps.length;
   colSize = maps[0].length();

   int[] dr = {-1, 1, 0, 0};
   int[] dc = {0, 0, -1, 1};
   ```

2. 이미 탐색한 육지를 다시 방문하지 않도록 `visited` 배열을 사용한다.

   ```java
   boolean[][] visited = new boolean[rowSize][colSize];
   ```

3. 지도 전체를 순회하면서 아직 방문하지 않은 위치를 찾는다.

   ```java
   for (int i = 0; i < rowSize; i++) {
       for (int j = 0; j < colSize; j++) {
           if (visited[i][j]) continue;
       }
   }
   ```

4. 현재 칸을 방문 처리한 뒤 바다인 `X`라면 BFS를 시작하지 않고 넘어간다.

   ```java
   visited[i][j] = true;

   if (maps[i].charAt(j) == 'X') {
       continue;
   }
   ```

5. 숫자가 적힌 육지라면 새로운 무인도의 시작점이므로 BFS를 시작한다.

   ```java
   Queue<int[]> q = new ArrayDeque<>();
   q.offer(new int[] {i, j});
   ```

6. BFS를 수행하면서 같은 무인도에 속한 모든 칸의 식량을 합산한다.

   ```java
   int foods = 0;

   while (!q.isEmpty()) {
       int[] cur = q.poll();
       int r = cur[0];
       int c = cur[1];

       foods += maps[r].charAt(c) - '0';
   }
   ```

   숫자가 문자로 저장되어 있으므로 `'0'`을 빼서 실제 정수 값으로 변환한다.

7. 현재 위치에서 상하좌우를 확인한다.

   다음 위치가 지도 범위를 벗어나거나 이미 방문했거나 바다라면 이동하지 않는다.

   ```java
   if (nr < 0 || nr >= rowSize ||
       nc < 0 || nc >= colSize ||
       visited[nr][nc] ||
       maps[nr].charAt(nc) == 'X') {
       continue;
   }
   ```

8. 이동 가능한 육지를 발견하면 큐에 추가하고 바로 방문 처리한다.

   ```java
   q.offer(new int[] {nr, nc});
   visited[nr][nc] = true;
   ```

   큐에 넣는 시점에 방문 처리해야 같은 위치가 여러 번 큐에 들어가는 것을 막을 수 있다.

9. BFS가 끝나면 하나의 무인도 탐색이 완료된 것이므로 식량의 총합을 저장한다.

   ```java
   days.add(foods);
   ```

10. 발견된 무인도가 하나도 없다면 문제 조건에 따라 `-1`을 추가한다.

   ```java
   if (days.isEmpty()) {
       days.add(-1);
   }
   ```

11. 각 무인도에서 머무를 수 있는 날짜 수를 오름차순으로 정렬한다.

   ```java
   days.sort((a, b) -> a - b);
   ```

12. `List<Integer>`를 `int[]`로 변환하여 반환한다.

   ```java
   int[] answer = days.stream()
       .mapToInt(Integer::intValue)
       .toArray();

   return answer;
   ```

## :black_nib: **Review**

- 상하좌우로 연결된 숫자 칸들을 하나의 무인도로 볼 수 있으므로 BFS를 사용했다.
- BFS를 진행하면서 각 칸의 식량 값을 바로 더해 무인도별 총 식량을 계산했다.
- 큐에 육지를 추가하는 순간 방문 처리해 같은 칸이 중복으로 큐에 들어가지 않도록 했다.
- 바다인 `X`는 BFS의 이동 대상에서 바로 제외하면 되므로 별도의 탐색이 필요하지 않았다.
- 무인도가 하나도 없는 경우 `[-1]`을 반환해야 하는 예외 조건을 따로 처리했다.
- 결과를 오름차순으로 반환해야 하므로 BFS 탐색 외에 정렬 비용 $O(K \log K)$이 추가된다.
- `List<Integer>`에서 `int[]`로 변환할 때 `stream().mapToInt().toArray()`를 활용할 수 있었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154540
