# [백준 - G5] 13549. 숨바꼭질 3

## ⏰ **time**

70분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N)^2$

## :round_pushpin: **Logic**

bfs 혹은 다익스트라를 이용해 최단거리 구하기

```java
	 while (!q.isEmpty()) {
            int now = q.poll();
            if (now * 2 <= 100000) {
                if (list[now * 2] == -1 || list[now * 2] > list[now]) {
                    q.add(now * 2);
                    list[now * 2] = list[now];
                    if (now * 2 == goal) break;
                }
            }
            if (now - 1 >= 0) {
                if (list[now - 1] == -1 || list[now - 1] > list[now] + 1) {
                    q.add(now - 1);
                    list[now - 1] = list[(now)] + 1;
                    if (now - 1 == goal) break;
                }
            }
            if (now + 1 <= 100000) {
                if (list[now + 1] == -1 || list[now + 1] > list[now] + 1) {
                    q.add(now + 1);
                    list[now + 1] = list[now] + 1;
                    if (now + 1 == goal) break;
                }
            }
        }
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/9012
