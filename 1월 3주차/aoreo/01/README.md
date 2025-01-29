# [백준 - 실버 5] 1427. 소트인사이드
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 우선순위큐 역순으로 정렬하기 위해 Collections.reverseOrder를 이용
```java
PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
```
2. 한 자리씩 우선순위큐에 넣기 
```java
        while(N > 0) {
            pQueue.add(N%10);
            N /= 10;
        }
```
3. pQueue에서 하나씩 뽑아서 출력 

## :black_nib: **Review**
- 실버 5 최고 

## 📡 Link
https://www.acmicpc.net/problem/1427
