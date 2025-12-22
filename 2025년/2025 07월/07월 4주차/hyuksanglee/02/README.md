# [백준 - G3] 1516. 게임 개발!
 
## ⏰  **time**
1시간 10분

## :pushpin: **Algorithm**
위상정렬

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

- 위상정렬을 사용해서 선행건물이 있으면 차수를 증가시키고 건물을 지을때 마다 -1해준다.
- 차수가 0이되면 큐에 넣는다
- 큐에서 하나 뽑고 그 건물에 시간을 선행 건물의 최대시간에 현재건물 건설 시간을 더해준다.
- 건물 건설 시간을 하나씩 출력해준다.

```java
	while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                result[next] = Math.max(result[next], result[cur] + time[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
```

## :black_nib: **Review**
- 위상정렬만 알면 쉽게 풀리는 문제에요

## 📡**Link**
- https://www.acmicpc.net/problem/1516
