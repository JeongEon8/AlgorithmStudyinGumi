# [백준] 14567. 선수과목 (Prerequisite)


## ⏰ **time**
30분

## :pushpin: **Algorithm**
DP, 그래프 이론, 위상정렬 

## ⏲️**Time Complexity**
O(n+m)

## :round_pushpin: **Logic**
선수과목 관계 입력
```java
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            inDegree[b]++; 
        }
```

진입 차수가 0인 노드(즉 선수 과목 없는 과목) -> 큐에 삽입
```java
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                semester[i] = 1; //첫학기에 수강가능
            }
        }
```

BFS...
```java
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                inDegree[next]--; // 선수과목 이수 완 
                if (inDegree[next] == 0) {
                    queue.add(next);
                    semester[next] = semester[now] + 1; // 다음 학기는 현재 학기 + 1
                }
            }
        }
```


## :black_nib: **Review**
역테의 기억이 새록새록 

## 📡**Link**
https://www.acmicpc.net/problem/14567
