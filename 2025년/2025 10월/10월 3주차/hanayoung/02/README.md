# [백준 - G5] 14567. 선수과목

## ⏰  **time**
60분

## :pushpin: **Algorithm**
위상정렬

## ⏲️**Time Complexity**
$O(N+M)$

## :round_pushpin: **Logic**
1. 각 과목의 수강가능 학기 수를 담을 answer 배열 생성 및 초기
```java
        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            answer[i] = 1;
        }
```
2. graph에 from이 없으면 생성, 해당 list에 to 추가
3. 진입차수를 나타내는 degree map에 to의 값에 1 더한 값 put. 없었다면 기본 값은 0에서 시작, from도 추가
```java
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

            degree.put(to, degree.getOrDefault(to, 0) + 1);
            degree.putIfAbsent(from, 0);
        }
```
4. 진입차수가 0인 노드들을 큐에 추가
```java
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: degree.entrySet()) {
            if(entry.getValue() == 0) q.add(entry.getKey());
        }
```
5. 노드를 하나씩 꺼내며, 현재 노드의 레벨을 가져오되 값이 없으면 1을 기본값으로.
6. cur을 key로 갖는 graph에서 리스트를 가져오기, 진입 차수 1 감소
7. 진입차수가 0일 경우 큐에 추가하고 level에 현재레벨+1로 삽입, answer값 업데이트
```java
        HashMap<Integer, Integer> level = new HashMap<>();
        while(q.size() > 0) {
            int cur = q.poll();
            int curLevel = level.getOrDefault(cur, 1);
            for(int next: graph.getOrDefault(cur, emptyList())) {
                degree.put(next, degree.get(next)-1);
                if(degree.get(next) == 0) {
                    q.add(next);
                    level.put(next, curLevel+1);
                    answer[next-1] = curLevel+1;
                }
            }
        }
```
8. 하나씩 꺼내서 출력


## :black_nib: **Review**
- 위상정렬이랑 친해지기 어렵다 :< 

## 📡**Link**
- https://www.acmicpc.net/problem/14567
