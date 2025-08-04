# [백준- G5] 1374. 강의실
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
- 강의 시작 시간이 같다면 빨리 끝나는 강의부터 배정하기
  - `시작 시간 기준 오름차순 정렬`, `시작 시간이 같다면 종료 시간 기준 오름차순 정렬`하도록 우선순위 큐 사용
- 가장 빨리 강의가 끝나는 곳에 새로운 강의를 배정하면 되므로, 우선순위 큐 하나 더 사용해서 강의 종료 시간 저장하기
  - `강의 종료 시간 기준 오름차순 정렬`하도록 우선순위 큐 사용
  - 새로운 강의 시작 시간이 가장 빨리 종료되는 시간보다 늦거나 같으면 같은 강의실 배정 가능
```java
PriorityQueue<Integer> useLecture = new PriorityQueue<>();
useLecture.offer(pq.poll().end); // N: 1 ~ 100,000
while (!pq.isEmpty()) {
    Lecture lecture = pq.poll();
    int lastTime = useLecture.peek(); // 가장 빨리 끝나는 강의 시간

    // 강의 시작 시간이 lastTime과 같거나 늦으면 같은 강의실 사용 가능
    if (lecture.start >= lastTime) {
        useLecture.poll();
        useLecture.offer(lecture.end);
    } else {
        useLecture.offer(lecture.end);
    }
}
System.out.println(useLecture.size());
```

## :black_nib: **Review**
우선순위 큐 정렬 줄 때 조심하자! 

## 📡**Link**
- https://www.acmicpc.net/problem/1374
