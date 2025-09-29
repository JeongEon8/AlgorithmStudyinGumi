# [백준 - G4] 1715. 카드 정렬하기

## ⏰  **time**
20분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 오름차순으로 정렬하는 PriorityQueue 변수 생성
```java
PriorityQueue<Integer> pQueue = new PriorityQueue<>();
```
2. 작은 걸 여러 번 더하는 게 최소화하는 것이므로, 가장 작은 두 개를 꺼내서 더하고 그걸 다시 pQueue에 넣고, pQueue의 크기가 1보다 클 때까지만 반복
3. 더한 횟수인 answer에는 first와 second를 더하기
```java
        while(pQueue.size() > 1) {
            int first = pQueue.poll();
            int second = pQueue.poll();

            answer += first+second;

            pQueue.add(first+second);
        }
```


## :black_nib: **Review**
- 생각만 빨리 하면 참 쉬운뎋 ,, 아니라면 너무 빙빙 어렵다 그리디

## 📡**Link**
- https://www.acmicpc.net/problem/1715
