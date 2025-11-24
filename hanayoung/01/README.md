# [프로그래머스 - Lv2] 도넛과 막대 그래프

## ⏰  **time**
5시간 그 이상..?

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(E)$

## :round_pushpin: **Logic**
1. 각 노드 번호와 들어오는 노드 리스트, 나가는 노드 리스트를 담을 Class 생성
```java
    public class Node {
        int num;
        List<Integer> in;
        List<Integer> out;
        
        public Node(int num) {
            this.num = num;
            this.in = new ArrayList<Integer>();
            this.out = new ArrayList<Integer>();
        }
    }
```
2. edges를 탐색하며 들어오고 나가는 노드들 저장하고 가장 큰 값을 저장, starts에는 시작하는 노드 저장
```java
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            map.computeIfAbsent(from, k -> new Node(from)).out.add(to); 
            map.computeIfAbsent(to, k -> new Node(to)).in.add(from);
            
            maxNode = Math.max(from, maxNode);
            maxNode = Math.max(to, maxNode);
            // in에는 얘를 가리키는 노드
            // out에는 얘가 가리키는 노드
            // from -> to
            starts.add(from);
        }
```
3. 시작 노드 중, 나가는 노드 리스트가 2개 이상인데, 들어오는 건 없는 노드는 추가 노드가 유일하므로 해당 노드를 저장하고 탈출
```java
        for(int start: starts) {
            if(map.get(start).out.size() >= 2 && map.get(start).in.size() == 0) {
                candidate = start;
                answer[0] = candidate;
                break;
            }
        }
```
4. 추가 노드와 이어지는 시작 노드들 탐색, 방문한 적 없는 노드만 탐색
5. 큐에 시작노드를 담고 방문 처리 후 큐 탐색
6. 이어서 갈 수 있지만 방문한 적 없는 노드들을 큐에 담고 방문처리
7. 만약 방문한 적 있다면 cycleCnt++
8. cycleCnt가 0이라면 막대 그래프, 1이라면 도넛 그래프, 2라면 시작지점과 교집합 노드에서 방문된 노드를 방문할 것이므로 8자 그래프로 판단  
```java
        for(int start: map.get(candidate).out) {
            if(visited[start] == false) {
                int cycleCnt = 0;
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                visited[start] = true;
                while(q.size() > 0) {
                    int cur = q.poll();
                    for(int next: map.get(cur).out) {
                        if(visited[next] == false) {
                            visited[next] = true;
                            q.add(next);
                        } else cycleCnt++;
                    }
                }
                switch(cycleCnt) {
                    case 0: answer[2]++;
                        break;
                    case 1: answer[1]++;
                        break;
                    case 2: answer[3]++;
                        break;
                }
            }
        }
```


## :black_nib: **Review**
- 진짜진짜진짜 오래 걸린 문제.. 추가 노드를 분별해내는 방법도 어려웠고 8자, 도넛, 막대 그래프 분리해내는 것도 너무너무 어려웠던 문제..

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/258711
