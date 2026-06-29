# [PGS - Lv2] 02_호텔 대실

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 우선순위 큐
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 시작 시간순, 끝나는 순으로 정렬
   ```
   Arrays.sort(book_time, (t1, t2) -> t1[0].equals(t2[0]) ?      t1[1].compareTo(t2[1]) : t1[0].compareTo(t2[0]));
   ```
2. 우선순위 큐에 끝나는 시간을 넣고 큐에서 하나씩 비교해서 작으면 넣어준다
3. 마지막으로 사이즈 계산해서 출력
```
   PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for (String[] time : book_time) {
            
            int start = changeTime(time[0]);
            int end = changeTime(time[1]) + 10;
            
            if (!que.isEmpty() && que.peek() <= start) {
                que.poll();
            }
            
            que.add(end);
        }
        
        return que.size();
```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/155651
