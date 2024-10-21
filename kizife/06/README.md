# [백준] 18352. 특정 거리의 도시 찾기 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
O(n + m)

## :round_pushpin: **Logic**
- 도로의 정보를 입력받는다.
```java
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 시작 도시
            int b = sc.nextInt(); // 도착 도시

            list.get(a).add(b); // a 도시에서 b 도시로 가는 도로 추가
        }
```

- bfs 탐색으로 거리를 계산한다. 
```java
        d[x] = 0; // 시작지점의 최단거리 값 0으로 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x); // 출발 도시 큐에 추가
        while (!queue.isEmpty()) {
            int now = queue.poll(); 

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i); // 다음으로 이동할 도시
                if (d[next] == -1) { //방문한 적이 없으면 
                    d[next] = d[now] + 1; //이전 좌표값의 +1을 해서 저장함. 
                    queue.offer(next);
                }
            }
        }
```

- 출력 로직을 구현한다. 최단거리 k인 도시 있으면 그 도시의 번호를... 없으면 -1을
```java
boolean check = false; // 최단거리가 k인 도시가 있는지 여부 
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) //없으면 ... -1 출력 
            System.out.println(-1);
    }
```


## :black_nib: **Review**
- ^^ㅎ 실버2라지만 어려웠다... 

## 📡**Link**
- https://www.acmicpc.net/problem/18352 
