# [PGS - Lv2] 01_지게차와 크레인

## ⏰**time**

62분

## :pushpin: **Algorithm**

* BFS
* 그래프 탐색
* 시뮬레이션
* 상태 관리

## ⏲️**Time Complexity**

$O(R \times N \times M)$

`R`은 요청의 개수, `N`은 창고의 행 개수, `M`은 열 개수이다.

각 요청을 처리할 때 창고 전체를 순회하면서 출고할 컨테이너를 찾으므로 $O(N \times M)$이 걸린다.

이후 `check()`에서 외부와 연결된 출고 공간을 BFS로 탐색한다.

하나의 `check()` 안에서는 각 칸을 최대 한 번 방문하므로 BFS 역시 $O(N \times M)$이다.

따라서 요청 하나당

```text
O(N × M)
```

이 걸리고, 요청이 총 `R`개이므로 전체 시간 복잡도는

```text
O(R × N × M)
```

이다.

## :round_pushpin: **Logic**

1. 각 컨테이너의 상태를 다음 4가지로 구분한다.

   ```java
   static final int YET_CAN_REACH = 0;     // 미출고 + 외부 접근 가능
   static final int YET_CANT_REACH = 1;    // 미출고 + 외부 접근 불가능
   static final int OUT_CAN_REACH = 2;     // 출고 + 외부 접근 가능
   static final int OUT_CANT_REACH = 3;    // 출고 + 외부 접근 불가능
   ```

   컨테이너가 출고되었는지뿐만 아니라 해당 위치가 외부와 연결되어 있는지도 함께 관리한다.

2. 창고의 가장자리에 있는 컨테이너는 처음부터 외부에서 접근할 수 있다.

   반대로 내부에 있는 컨테이너는 처음에는 외부에서 접근할 수 없으므로 `YET_CANT_REACH`로 초기화한다.

   ```java
   for (int i = 1; i < N - 1; i++) {
       for (int j = 1; j < M - 1; j++) {
           visited[i][j] = YET_CANT_REACH;
       }
   }
   ```

   배열의 기본값이 `0`이므로 가장자리의 상태는 자연스럽게 `YET_CAN_REACH`가 된다.

3. 모든 요청을 순서대로 처리한다.

   ```java
   for (String request : requests)
       pick(storage, request);
   ```

4. 요청의 길이가 `2`라면 크레인을 사용한 요청이다.

   크레인은 외부 접근 여부와 관계없이 해당 종류의 모든 컨테이너를 출고할 수 있다.

   ```java
   if (request.length() == 2) {
       ...
   }
   ```

5. 크레인으로 외부 접근이 가능한 컨테이너를 제거하면 해당 빈 공간은 계속 외부와 연결되어 있으므로 `OUT_CAN_REACH`로 변경한다.

   ```java
   if (visited[i][j] == YET_CAN_REACH
       && storage[i].charAt(j) == c) {

       visited[i][j] = OUT_CAN_REACH;
       answer--;
   }
   ```

6. 외부에서 접근할 수 없는 내부 컨테이너를 크레인으로 제거한 경우에는 아직 외부와 연결되지 않은 빈 공간이므로 `OUT_CANT_REACH`로 변경한다.

   ```java
   else if (visited[i][j] == YET_CANT_REACH
            && storage[i].charAt(j) == c) {

       visited[i][j] = OUT_CANT_REACH;
       answer--;
   }
   ```

7. 요청의 길이가 `1`이라면 지게차 요청이다.

   지게차는 외부에서 접근 가능한 컨테이너만 출고할 수 있으므로 `YET_CAN_REACH` 상태의 컨테이너만 제거한다.

   ```java
   if (visited[i][j] == YET_CAN_REACH
       && storage[i].charAt(j) == c) {

       visited[i][j] = OUT_CAN_REACH;
       answer--;
   }
   ```

8. 컨테이너를 출고한 뒤에는 새롭게 외부와 연결되는 공간이 생길 수 있으므로 `check()`를 실행한다.

   ```java
   check(storage);
   ```

9. `OUT_CAN_REACH` 상태인 빈 공간에서 BFS를 시작한다.

   ```java
   if (visited[i][j] == OUT_CAN_REACH && !v[i][j]) {
       Queue<int[]> q = new ArrayDeque<>();

       q.offer(new int[] {i, j});
       v[i][j] = true;
   }
   ```

   이 공간들은 외부와 연결된 빈 공간이므로 여기서부터 상하좌우로 이동하면서 새롭게 접근 가능한 영역을 찾는다.

10. BFS 도중 기존에는 외부와 연결되지 않았던 빈 공간 `OUT_CANT_REACH`를 발견하면 외부와 연결된 빈 공간으로 변경한다.

```java
if (visited[nr][nc] == OUT_CANT_REACH)
    visited[nr][nc] = OUT_CAN_REACH;
```

빈 공간이므로 BFS 탐색도 계속 이어갈 수 있다.

```java
if (visited[nr][nc] == OUT_CAN_REACH)
    q.offer(new int[] {nr, nc});
```

11. 외부 접근이 불가능했던 컨테이너 `YET_CANT_REACH`와 연결되었다면 이제 지게차로 접근할 수 있으므로 `YET_CAN_REACH`로 상태를 변경한다.

```java
if (visited[nr][nc] == YET_CANT_REACH)
    visited[nr][nc] = YET_CAN_REACH;
```

단, 컨테이너가 실제로 존재하는 칸이므로 BFS를 통해 통과하지는 않는다.

12. 모든 요청을 처리한 뒤 남아 있는 컨테이너의 개수를 반환한다.

```java
return answer;
```

## :black_nib: **Review**

* 단순히 컨테이너의 출고 여부만 저장해서는 지게차로 접근할 수 있는지를 판단하기 어려워 외부 접근 가능 여부까지 포함한 4가지 상태로 관리했다.
* 가장자리는 처음부터 외부와 연결되어 있고 내부는 접근할 수 없다는 점을 이용해 초기 상태를 설정했다.
* 크레인은 접근 여부와 상관없이 컨테이너를 제거할 수 있지만, 제거된 위치가 즉시 외부와 연결되는지는 별도로 구분해야 했다.
* 컨테이너가 제거되면서 기존에 막혀 있던 내부 공간이 외부와 연결될 수 있으므로 매 요청 이후 BFS를 통해 접근 가능 상태를 갱신했다.
* `OUT_CANT_REACH`는 외부와 연결되면 `OUT_CAN_REACH`로 변경하고 계속 탐색할 수 있지만, `YET_CANT_REACH`는 실제 컨테이너가 있기 때문에 `YET_CAN_REACH`로만 변경하고 BFS로 통과하지 않는 것이 중요했다.
* 출고 여부와 연결 여부를 동시에 관리해야 해서 상태 정의가 다소 복잡했지만, 상태를 명확하게 나누면서 시뮬레이션할 수 있었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/388353?language=java
