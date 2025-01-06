# [백준 - S2] 16953. A → B

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- BFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

BFS를 통해 2가지 연산을 해주면서 가장 빨리 도착하는 값을 계산

```java
	 while (!q.isEmpty()) {
            int qsize= q.size();
            count++;
            for (int k = 0; k < qsize; k++) {
                long now = q.poll();
                if (now == m) {
                    System.out.println(count);
                    return;
                }
                if (now > m) continue;
                q.add(now * 2);
                q.add(now * 10 + 1);
            }
        }
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/16953
