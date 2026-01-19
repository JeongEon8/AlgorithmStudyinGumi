# [백준 - S3] 2606. 바이러스

## ⏰  **time**
10분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N+M)$

## :round_pushpin: **Logic**
1. 이어져있는 컴퓨터 번호의 인덱스의 리스트에 컴퓨터 번호 추가
```java
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int pairA = Integer.parseInt(st.nextToken());
            int pairB = Integer.parseInt(st.nextToken());

            computers[pairA].add(pairB);
            computers[pairB].add(pairA);
        }
```
2. queue가 빌 때까지 반복. 연결되어있는 컴퓨터들을 의미하는 computers[cur]을 순회하며 방문하지 않았으면 answer++, 값 업데이트하고 queue에 추가
```java
       while(q.size() > 0) {
            int cur = q.poll();
            for(int con: computers[cur]) {
                if(visited[con] == false) {
                    answer++;
                    visited[con] = true;
                    q.add(con);
                }
            }
        }
```

## :black_nib: **Review**
- 익숙한 BFS 알고리즘 문제 야호

## 📡 Link
https://www.acmicpc.net/problem/2606
