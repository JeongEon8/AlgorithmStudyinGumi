# [백준 - G5] 16928. 뱀과 사다리 게임

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
bfs를 이용해 가장 빨리 도착하는 주사위 횟수을 확인하고 그 이상인 가지수는 제거해준다.

```java
while (!q.isEmpty()) {
            Dot now = q.poll();
            if (now.count >= answer) continue;
            if (now.pos >= 100) {
                answer = now.count;
                continue;
            }
            if (counts[now.pos] != 0 && now.count >= counts[now.pos]) continue;
            counts[now.pos] = now.count;
            int nowPos = now.pos;
            int nowCount = now.count;
            for (int i = nowPos + 1; i < nowPos + 7; i++) {
                if (i > 100) continue;
                if (counts[i] != 0 && nowCount + 1 >= counts[i]) continue;
                if (routes[i] != 0) {
                    q.add(new Dot(now.count + 1, routes[i]));
                } else {
                    q.add(new Dot(now.count + 1, i));
                }
            }
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/16928
