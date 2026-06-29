# [PGS - Lv2] 02_숫자 변환하기

## ⏰**time**

14분

## :pushpin: **Algorithm**

* BFS
* Queue
* 방문 체크
* 최단 거리

## ⏲️**Time Complexity**

$O(Y)$
`x`부터 `y`까지 만들 수 있는 숫자를 최대 한 번씩만 방문한다.
각 숫자마다 `+ n`, `* 2`, `* 3` 세 가지 연산만 확인하므로 전체 시간 복잡도는 $O(Y)$이다.

## :round_pushpin: **Logic**

1. `x`를 `y`로 변환하기 위해 사용할 수 있는 연산은 다음 세 가지이다.

   ```text
   현재 숫자 + n
   현재 숫자 * 2
   현재 숫자 * 3
   ```

2. 최소 연산 횟수를 구해야 하므로 BFS를 사용한다.

   BFS는 시작점에서 가까운 거리부터 탐색하기 때문에, 처음으로 `y`에 도달했을 때의 횟수가 최소 연산 횟수이다.

   ```java
   Queue<int[]> q = new ArrayDeque<>();
   boolean[] visited = new boolean[y + 1];

   q.offer(new int[] { x, 0 });
   visited[x] = true;
   ```

3. 큐에는 `{현재 숫자, 연산 횟수}` 형태로 저장한다.

   ```java
   int[] cur = q.poll();
   int num = cur[0];
   int cnt = cur[1];
   ```

4. 현재 숫자가 `y`와 같다면, 현재까지의 연산 횟수 `cnt`를 반환한다.

   ```java
   if (num == y) {
       return cnt;
   }
   ```

5. 현재 숫자에서 이동할 수 있는 다음 숫자들을 배열로 만든다.

   ```java
   int[] nexts = { num + n, num * 2, num * 3 };
   ```

6. 다음 숫자가 `y`를 초과하면 더 이상 확인할 필요가 없다.

   또한 이미 방문한 숫자는 다시 큐에 넣지 않는다.

   ```java
   for (int next : nexts) {
       if (next > y || visited[next])
           continue;

       visited[next] = true;
       q.offer(new int[] { next, cnt + 1 });
   }
   ```

7. 큐가 빌 때까지 `y`에 도달하지 못했다면, 변환할 수 없는 경우이므로 `-1`을 반환한다.

   ```java
   return -1;
   ```

## :black_nib: **Review**

* 처음에는 방문 체크 없이 BFS를 수행해서 같은 숫자가 큐에 여러 번 들어가 메모리 초과가 발생했다.
* BFS에서는 같은 숫자에 처음 도달했을 때가 최소 연산 횟수이므로, 이후 같은 숫자를 다시 방문할 필요가 없다.
* `visited` 배열을 사용해 각 숫자를 한 번만 큐에 넣도록 수정하니 메모리 사용을 줄일 수 있었다.
* `+ n`, `* 2`, `* 3` 연산 결과가 `y`를 초과하면 정답이 될 수 없으므로 큐에 넣지 않고 제외했다.
* 최소 연산 횟수 문제이기 때문에 BFS 접근이 직관적이었다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154538
