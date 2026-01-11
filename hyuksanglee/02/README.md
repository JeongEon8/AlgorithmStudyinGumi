# [프로그래머스 - lv2] 155651. 호텔 대실

## ⏰**time**
30분

## :pushpin: **Algorithm**
* 우선순위 큐

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. 일단 문자열로 시간 분을 정수 분으로 고쳐준다.
2. 시작 시간을 빠르고 끝나는 시간이 빠른순으로 정렬 해준다.
3. 배열에서 하나씩 꺼내서 큐에 담아준다.
   - 큐에 값이 시작 시간보다 작을 경우 큐에 있는 값을 꺼내준다.
4. 큐에 사이즈를 비교해서 크면 결과 값을 변경해준다.

```
for (String[] booking : book_time) {
       int start = toMinute(booking[0]);
       int end = toMinute(booking[1]) + 10; 
     
      
       if (!que.isEmpty() && que.peek() <= start) {
           que.poll();
       }
     
       que.add(end);
     
       answer = Math.max(answer, que.size());
}
```

## :black_nib: **Review**
- 

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/155651
