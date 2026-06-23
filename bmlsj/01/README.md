# [PGS - lv2] 01. 디펜스 게임

## ⏰**time**

30분

## :pushpin: \*\*Algorithm

그리디

## ⏲️**Time Complexity**

$O(Nlogk)$

## :round_pushpin: **Logic**

1. `enemy`를 힙에 넣기
2. 힙의 크기가 `k`를 초과 시, 가장 작은 적의 수를 꺼내 병사로 막는다.
3. 병사가 부족하면 종료

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

for(int i = 0; i < enemy.length; i++) {
    pq.offer(enemy[i]);

    if (pq.size() > k) {
        n -= pq.poll();

        if (n < 0) {
            return i;
        }
    }
}
```

## :black_nib: **Review**

- 조합을 사용하면 $10^6$이라서 엄청난 시간초과가 발생할 지도
- $logn$의 시간 복잡도를 가지는 우선순위 큐를 사용

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/142085>
