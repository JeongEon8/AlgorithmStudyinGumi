# [백준 - S4] 18110. solved.ac

## ⏰  **time**
15분

## :pushpin: **Algorithm**
구현, 정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 우선순위큐에 n개의 난이도 삽입
```java
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }
```
2. 제외할 인원 숫자 계산. 15퍼센트 인원의 반올림
```java
int exceptNum = Math.round((float)n*15/100);
```
3. 15퍼센트 인원 제외하기
```java
        for(int i = 0; i < exceptNum; i++) {
            pq.poll();
        }
```
4. 15퍼센트 인원(exceptNum) 남겨두고 꺼내서 answer에 더하기
```java
        while(pq.size() > exceptNum) {
            answer += pq.poll();
        }
```
5. 다 더한 answer를 n-exceptNum*2 으로 나눠서 반올림 계산
```java
answer = Math.round((float)answer/(n-2*exceptNum));
```


## :black_nib: **Review**
- 우선순위큐 최고!

## 📡 Link
https://www.acmicpc.net/problem/18110
