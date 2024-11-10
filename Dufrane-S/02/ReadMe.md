# [백준 - S2] 11725. 트리의 부모 찾기

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- BFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

트리를 입력받고 1을 기준으로 연결된 노드를 탐색해가며 부모 노드를 찾는다

```java
	  while (!q.isEmpty()) {
            int now = q.poll();
            done[now] = 1;
            for (int temp : list[now]) {
                if (done[temp] != 0) continue;
                done[temp] = 1;
                q.add(temp);
                answer[temp] = now;
            }
        }
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/11725
