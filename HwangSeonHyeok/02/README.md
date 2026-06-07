# [PGS - LV2] 142085. 디펜스 게임

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
우선순위큐에 넣어서 무적권을 사용한 것으로하고 무적권이 넘치는 갯수부턴 우선순위 큐에서 가장 적이 적었던 라운드부터 병사를 소모한 것으로 친다.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
for(int i = 0; i<enemy.length; i++){
    pq.add(enemy[i]);
    if(pq.size()>k){
        n -= pq.poll();
    }
    if(n<0){
        return i;
    }
}
return enemy.length;
```

## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/142085