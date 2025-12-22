# [백준 - S4] 2164. 카드2

## ⏰  **time**
20분

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 우선 카드번호 1~N까지 큐에 삽입
```java
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
```
2. q 크기가 1보다 클 때까지 반복, 하나 꺼내고, 하나 더 꺼내서 맨 뒤로 넣기를 반복
```java
        while(q.size() > 1) {
            q.poll();
            int second = q.poll();
            q.add(second);
        }
```
3. 마지막 값 출력
```java
System.out.println(q.poll());
```


## :black_nib: **Review**
- 간단한 실버 최고 ! 큐 최고 !

## 📡**Link**
- https://www.acmicpc.net/problem/2164
