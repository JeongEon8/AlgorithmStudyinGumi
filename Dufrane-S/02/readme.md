# [백준 - S1] 11403. 경로 찾기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
bfs를 통해 연결 확인
```java
 while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < N; i++) {
                int next = list.get(now).get(i);
                if(next==1){
                    if (i == end) return true;
                    if (!done[i]) {
                        q.add(i);
                        done[i] = true;
                    }
                }
            }
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/11403
