# [프로그래머스 - Lv2] 더 맵게

## ⏰  **time**
20분

## :pushpin: **Algorithm**
우선순위큐

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 우선순위큐 생성, scoville 하나씩 담기
```java
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int s: scoville) {
            pQueue.add(s);
        }
```
2. 가장 작은 값이 K보다 작을 때까지 반복
3. pQueue 사이즈가 2보다 작을 경우 두 개를 꺼내서 비교가 불가능하므로 answer = -1로 업데이트 후 탈출
4. 두 개의 값을 꺼내서 min + next*2 한 것을 다시 pQueue에 삽입 후 answer++
```java
        while(pQueue.peek() < K) {
            if(pQueue.size() < 2) {
                answer = -1;
                break;
            }
            int min = pQueue.poll();
            int next = pQueue.poll();
            pQueue.add(min+next*2);
            answer++;
        }
```


## :black_nib: **Review**
- 알고리즘 고득점 kit 정복하기 ! 우선순위큐로 푸는 간단한 문제 야호 ! 처음에 문제 제대로 안 읽어서 틀려버리기!

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/42626
