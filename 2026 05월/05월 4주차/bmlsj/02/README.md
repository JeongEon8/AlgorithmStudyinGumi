# [PGS - Lv2] 02\_호텔 대실

## ⏰**time**

30min

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 시작 시간 순으로 정렬
2. PQ에 대실종료 시간을 넣는다.
3. 다음 시작시간이 대실종료 시간 이후이면 방 재사용 가능으로, PQ에서 제거 후 새 종료 시간을 넣는다.
4. 가장 많이 필요한 방의 수를 `answer`에 갱신

```java
Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

PriorityQueue<Integer> pq = new PriorityQueue<>();
for(String[] time: book_time) {

    int start = convert(time[0]);
    int end = convert(time[1]) + 10;

    // 재사용 가능하면 poll()
    while(!pq.isEmpty() && pq.peek() <= start) {
        pq.poll();
    }

    pq.offer(end);
    answer = Math.max(answer, pq.size());
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/155651>
