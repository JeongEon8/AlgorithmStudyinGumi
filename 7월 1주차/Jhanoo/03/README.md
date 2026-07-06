# [PGS - Lv2] 03_다리를 지나는 트럭

## ⏰**time**

28분

## :pushpin: **Algorithm**

* Queue
* 시뮬레이션
* 구현

## ⏲️**Time Complexity**

$O(T + N)$
`N`은 트럭의 개수이고, `T`는 마지막 트럭이 다리에 진입할 때까지 흐른 시간이다.

매 초마다 시간을 1씩 증가시키며 다리에서 빠져나갈 트럭과 새로 진입할 트럭을 확인한다.
각 트럭은 큐에 한 번 들어가고 한 번 나오므로 트럭 처리 자체는 $O(N)$이며, 전체 반복 횟수는 시간 흐름에 따라 $O(T)$이다.

## :round_pushpin: **Logic**

1. 다리 위에 있는 트럭의 정보를 저장하기 위해 큐를 사용한다.

   각 원소에는 다음 두 값을 저장한다.

   ```text
   트럭의 무게
   다리에 진입한 시간
   ```

   ```java
   Queue<int[]> q = new ArrayDeque<>();
   ```

2. 다음으로 진입할 트럭의 인덱스 `idx`, 현재 시간 `t`, 다리 위 트럭들의 총 무게 `curWeight`를 관리한다.

   ```java
   int idx = 0;
   int t = 0;
   int curWeight = 0;
   ```

3. 아직 모든 트럭이 다리에 진입하지 않았다면 매 초마다 시뮬레이션을 진행한다.

   ```java
   while (idx < truck_weights.length) {
       t++;
   }
   ```

4. 큐의 맨 앞 트럭이 다리에 진입한 뒤 `bridge_length`초가 지났다면 다리를 모두 건넌 것이다.

   해당 트럭을 큐에서 제거하고 현재 다리 위 총 무게에서도 뺀다.

   ```java
   int[] cur = q.peek();

   if (cur != null && t - cur[1] == bridge_length) {
       cur = q.poll();
       curWeight -= cur[0];
   }
   ```

5. 다음 트럭을 올려도 다리의 최대 하중 `weight`를 넘지 않는다면 다리에 진입시킨다.

   큐에는 트럭의 무게와 현재 진입 시간을 함께 저장한다.

   ```java
   if (curWeight + truck_weights[idx] <= weight) {
       curWeight += truck_weights[idx];
       q.offer(new int[] { truck_weights[idx++], t });
   }
   ```

6. 마지막 트럭이 다리에 진입한 시점에서 아직 다리를 빠져나오지는 않았다.

   마지막 트럭이 다리를 완전히 건너는 데 `bridge_length`초가 더 필요하므로 이를 더해 반환한다.

   ```java
   return t + bridge_length;
   ```

## :black_nib: **Review**

* 다리 위 트럭의 상태와 진입 시점을 함께 관리하기 위해 큐에 `{무게, 진입 시간}`을 저장했다.
* 매 초마다 큐의 맨 앞 트럭이 다리를 다 건넜는지 확인하고, 다리 하중에 여유가 있으면 다음 트럭을 진입시키는 방식으로 시뮬레이션했다.
* 현재 다리 위 총 무게를 `curWeight`로 따로 관리해 매번 큐 전체를 순회하지 않도록 했다.
* 마지막 트럭이 다리에 진입한 뒤에도 다리를 완전히 건너는 시간이 필요하므로 `bridge_length`를 추가해야 했다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42583
