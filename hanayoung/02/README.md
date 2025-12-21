# [백준 - S5] 2751. 수 정렬하기 2

## ⏰  **time**
10분

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 우선순위큐 타입의 변수 생성
```java
PriorityQueue<Integer> pQueue = new PriorityQueue<>();
```
2. N개의 값을 입력받으며 우선순위큐에 삽입
```java
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pQueue.add(Integer.valueOf(st.nextToken()));
        }
```
3. StringBuilder에 우선순위큐의 값을 하나씩 꺼내서 붙이기
```java
        StringBuilder sb = new StringBuilder();

        while(pQueue.size() > 0) {
            sb.append(pQueue.poll()).append("\n");
        }
```

## :black_nib: Review
- 정렬은,,직접 안하고 우선순위큐한테 줘버리기

## 📡**Link**
- https://www.acmicpc.net/problem/2751
