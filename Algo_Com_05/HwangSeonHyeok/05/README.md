# [백준 - s1] 13700. 완전 범죄

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## :round_pushpin: **Logic**

map에다 현제 step수를 기록하면서 bfs로 도착지점까지의 스텝을 계산한다.

```java
   Queue<Integer> q = new ArrayDeque<>();
    map[s] = 1;
    q.add(s);
    while (!q.isEmpty() && map[d] == 0) {
        int current = q.poll();
        int forward = current + f;
        int back = current - b;
        if (forward <= n && map[forward] == 0) {
            map[forward] = map[current] + 1;
            q.add(forward);
        }

        if (back >= 0 && map[back] == 0) {
            map[back] = map[current] + 1;
            q.add(back);
        }
    }

```

## 📡**Link**

https://www.acmicpc.net/problem/13700
