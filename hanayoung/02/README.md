# [백준 - G5] 5972. 택배 배송
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O((N + M) log N)$

## :round_pushpin: **Logic**
1. 최대로 거리 초기화
```java
        for(int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            maps[i] = new ArrayList<>();
        }
```
2. 가능한 길을 배열로 넣기
```java
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cnt = Integer.parseInt(st.nextToken());

            maps[start].add(new Node(end, cnt));
            maps[end].add(new Node(start, cnt));
        }
```
3. Node 클래스 생성해서 cost로 비교할 수 있게끔 Comparable implements
```java
    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost < o.cost) return -1;
            else return 1;
        }
        
    }
```
4. 더 짧은 거리가 있다면 업데이트
```java
        while(pQueue.size() > 0) {
            Node cur = pQueue.poll();
            visited[cur.v] = true;
            for(Node node: maps[cur.v]) {
                if(dist[node.v] > dist[cur.v] + node.cost) {
                    dist[node.v] = dist[cur.v] + node.cost;
                    pQueue.add(node);
                }
            }
        }
```

## :black_nib: **Review**
다익스트라 진짜진짜 오랜만 다까먹었넹

## 📡**Link**
- https://www.acmicpc.net/problem/5972
