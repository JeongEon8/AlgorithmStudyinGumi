# [PGS - Lv2] 03_배달

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 다익스트라

## ⏲️**Time Complexity**
E는 간선 개수 N은 노드 개수
$O(ElogN)$

## :round_pushpin: **Logic**
1. 각 마을까지의 최단 거리를 저장하는 배열 distance를 생성하고, 모든 값을 매우 큰 값(INF)으로 초기화한다.
   ```java
        int[] distance = new int[N + 1];
        int INF = 100_000_000;
        Arrays.fill(distance, INF);
   ```

2. 각 마을과 도로 정보를 이용하여 인접 리스트 형태의 그래프를 생성한다. graph[from]에 (to, cost) 형태로 저장한다. 양방향 도로이므로 양쪽 모두 추가한다.
   ```java
        for(int i = 0; i < road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
   ```

3. 큐에서 가장 비용이 작은 노드를 꺼내고 > 이미 더 짧은 경로가 존재하면 무시 > 현재 노드와 연결된 모든 이웃 노드 확인 > 더 짧은 경로가 발견되면 거리 갱신 후 큐에 삽입
   ```java
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currNode = current.to;
            int currCost = current.cost;

            if(currCost > distance[currNode]){
                continue;
            }
            
            for(Node neighbor : graph[currNode]){
                if(distance[neighbor.to] > distance[currNode] + neighbor.cost){
                    distance[neighbor.to] = distance[currNode] + neighbor.cost;
                    pq.add(new Node(neighbor.to, distance[neighbor.to]));
                }
            }
        }
   ```

4. 최종적으로 distance 배열을 순회하면서, 1번 마을로부터 거리가 K 이하인 마을의 개수를 센다.
   ```java
        for(int i = 1; i <= N; i++){
            if(distance[i] <= K){
                answer++;
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12978
