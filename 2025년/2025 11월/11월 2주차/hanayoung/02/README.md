# [프로그래머스 - Lv2] 서버 증설 횟수

## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 증설된 서버의 만료시간을 담을 큐 생성
```java
        Queue<Integer> server = new LinkedList<>();
        int size = 1;
```
2. players만큼 탐색하며, 만료된 서버 찾아서 꺼내고 size 값 업데이트
3. 이용자 수보다 현재 서버 수가 크면 그대로 진행
4. 아니라면, 이용자수를 감당할만큼 size++, 큐에 만료시간 넣어서 추가하고 answer++
```java
        for(int i = 0; i < players.length; i++) {
            // i로 현재 시간 파악하기
            while(server.size() > 0 && server.peek() < i) {
                size--;
                server.poll();
            }
            if(players[i] < size*m) continue;
            while(players[i] >= size*m) {
                size++;
                server.add(i+k-1);
                answer++;
            }
        }
```

## :black_nib: **Review**
- 할 만 한 레벨2 문제 발견

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/389479
