# [프로그래머스 - lv2] 다리를 지나는 트럭

## ⏰  **time**

40분

## ⏲️**Time Complexity**

$O(N + L)$

## :round_pushpin: **Logic**

현재 다리 위 총 무게에서 제거된 트럭의 무게를 제거
다음 트럭이 존재하고, `weight`를 초과하지 않는 경우 큐에 추가

조건을 만족하지 못하면 0을 삽입하고 다음을 진행한다.
모든 트럭이 다리를 건너고, 다리 위 무게가 0이 될 때까지 반복

```java
Queue<Integer> bridge = new LinkedList<>();

for (int i = 0; i < bridge_length; i++) {
    bridge.add(0);
}

while (idx < truck_weights.length || current_weight > 0) {
    time++;

    int leaving = bridge.poll();
    current_weight -= leaving;

    if (idx < truck_weights.length && current_weight + truck_weights[idx] <= weight) {
        bridge.add(truck_weights[idx]);
        current_weight += truck_weights[idx];
        idx++;
    } else {
        bridge.add(0);
    }
}
```

## :black_nib: Review

## 📡**Link**

<https://school.programmers.co.kr/learn/courses/30/lessons/42583>
