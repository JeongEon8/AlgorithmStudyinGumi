# [PGS - Lv2] 01_더 맵게

## ⏰**time**

19분

## :pushpin: **Algorithm**

* PriorityQueue
* Heap
* Greedy

## ⏲️**Time Complexity**

$O(N \log N)$
`N`은 `scoville` 배열의 길이이다.
모든 원소를 우선순위 큐에 넣고, 음식을 섞을 때마다 `poll`, `add` 연산을 수행한다.
`PriorityQueue`의 삽입과 삭제는 각각 $O(\log N)$이므로 전체 시간 복잡도는 $O(N \log N)$이다.

## :round_pushpin: **Logic**

1. 모든 음식의 스코빌 지수가 `K` 이상이 되도록 만들어야 한다.

   매번 가장 맵지 않은 음식 2개를 섞어야 하므로, 최솟값을 빠르게 꺼낼 수 있는 `PriorityQueue`를 사용한다.

   ```java
   PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
   ```

2. 주어진 모든 스코빌 지수를 우선순위 큐에 넣는다.

   ```java
   for (int n : scoville) {
       pq.add(n);
   }
   ```

3. 우선순위 큐에서 가장 작은 스코빌 지수를 꺼낸다.

   ```java
   int cur = pq.poll();
   ```

4. 가장 작은 값이 이미 `K` 이상이라면, 모든 음식의 스코빌 지수가 `K` 이상이라는 뜻이다.

   우선순위 큐는 항상 최솟값을 먼저 꺼내기 때문이다.

   ```java
   if (cur >= K) {
       break;
   }
   ```

5. 가장 작은 값이 `K`보다 작은데, 더 이상 섞을 음식이 없다면 목표를 만들 수 없다.

   이 경우 `-1`을 반환한다.

   ```java
   if (pq.isEmpty()) {
       return -1;
   }
   ```

6. 두 번째로 작은 스코빌 지수를 꺼내고, 문제에서 주어진 공식에 따라 새로운 음식을 만든다.

   ```java
   int cur2 = pq.poll();
   pq.add(cur + cur2 * 2);
   ```

7. 음식을 한 번 섞었으므로 횟수를 증가시킨다.

   ```java
   cnt++;
   ```

8. 모든 음식의 스코빌 지수가 `K` 이상이 될 때까지 위 과정을 반복하고, 최종 섞은 횟수 `cnt`를 반환한다.

   ```java
   return cnt;
   ```

## :black_nib: **Review**

* 매번 가장 작은 스코빌 지수 2개를 선택해야 하므로, 최소 힙 구조인 `PriorityQueue`를 사용하는 것이 핵심이었다.
* 가장 작은 값만 확인하면 전체 음식이 조건을 만족하는지 판단할 수 있다는 점이 중요했다.
* 가장 작은 값이 `K`보다 작은데 큐에 남은 음식이 없다면 더 이상 섞을 수 없으므로 `-1`을 반환해야 했다.
* `PriorityQueue`를 사용하면 매번 정렬하지 않고도 최솟값 2개를 효율적으로 꺼낼 수 있어 적절한 풀이였다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42626
