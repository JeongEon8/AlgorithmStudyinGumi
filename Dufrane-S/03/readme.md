# [백준 - G4] 12851. 숨바꼭질 2

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
bfs를 이용해 빨리 도착하는 시간을 찾고 그 이상 시간이 걸리는 방법은 제거한다.

```java
while (!q.isEmpty()) {
            Position now = q.poll();
            if (done[now.pos] == 1 && now.count > counts[now.pos]) continue;
            if (now.pos == end) {
                done[now.pos] = 1;
                counts[now.pos] = now.count;
                answer++;
                continue;
            }
            done[now.pos] = 1;
            counts[now.pos] = now.count;
            if (now.pos < end) {
                if (now.pos - 1 >= 0) {
                    q.add(new Position(now.pos - 1, now.count + 1));
                }
                if (now.pos != 0 && now.pos * 2 <= 100000) {
                    q.add(new Position(now.pos * 2, now.count + 1));
                }
                q.add(new Position(now.pos + 1, now.count + 1));
            } else {
                q.add(new Position(now.pos - 1, now.count + 1));
            }
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/12851
