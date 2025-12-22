# [프로그래머스 - Lv2] 전력망을 둘로 나누기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. tree를 담을 Map 생성, 연결 리스트 담기
```java
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int[] wire: wires) {
            tree.computeIfAbsent(wire[0], k -> new ArrayList<Integer>()).add(wire[1]);
            tree.computeIfAbsent(wire[1], k -> new ArrayList<Integer>()).add(wire[0]);
        }
```
2. wires를 돌며, wire[0]을 기준으로 도는 건 set1, wire[1]을 기준으로 도는 건 set2로 설정
3. Queue에 wire[0]부터 넣고 연결되었으며 wire[1]이 아닌 노드를 기준으로 연결되었고 아직 set1에 없는 노드들을 map과 queue에 삽입
4. wire[1]에 대해서도 동일한 작업 반복
```java
        for(int[] wire: wires) {
            Map<Integer, Boolean> set1 = new HashMap<>();
            Map<Integer, Boolean> set2 = new HashMap<>();    
            set1.put(wire[0], true);
            set2.put(wire[1], true);
            
            Queue<Integer> q = new LinkedList<>();
            q.add(wire[0]);
            while(q.size() > 0) {
                int node = q.poll();
                if(node != wire[1]) {
                    for(int next: tree.get(node)) {
                        if(set1.get(next) == null) {
                            set1.put(next, true);
                            q.add(next);
                        }
                    }
                }
            }
            
            q.add(wire[1]);
            while(q.size() > 0) {
                int node = q.poll();
                if(node != wire[0]) {
                    for(int next: tree.get(node)) {
                        if(set2.get(next) == null) {
                            set2.put(next, true);
                            q.add(next);
                        }
                    }
                }
            }
```
5. set1과 set2의 크기의 차를 answer과 비교해서 더 작은 값으로 업데이트
```java
answer = Math.min(answer, Math.abs(set2.size() - set1.size()));
```
6. 만약 answer가 0이라면 가능한 가장 적은 차이이므로 종

## :black_nib: **Review**
- 알고리즘 고득점 kit 정복하기 ! 완탐 돌아! 

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/86971
