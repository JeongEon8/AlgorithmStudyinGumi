# [PGS - Lv2] 호텔 대실 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 우선순위 큐

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

이 문제는 최소한의 객실로 모든 예약을 수용하는 스케줄링 문제였다. 그리디 알고리즘을 기반으로, 현재 사용 중인 객실의 종료 시간을 우선순위 큐로 관리하여 최적의 해를 구했다.

```java
        for(int i = 0; i < N; i++){
            String[] sTime = book_time[i][0].split(":");
            String[] eTime = book_time[i][1].split(":");

            int start = Integer.parseInt(sTime[0]) * 60 + Integer.parseInt(sTime[1]);
            int end = Integer.parseInt(eTime[0]) * 60 + Integer.parseInt(eTime[1]) + 10;

            list.add(new Info(start, end));
        }
        Collections.sort(list);

        for(int i = 0; i < N; i++){
            Info next = list.get(i);

            if(pq.isEmpty()){
                pq.add(next.end);
                answer++;
            }else{
                if(pq.peek() <= next.start){
                    pq.poll();
                    pq.add(next.end);
                }else{
                    pq.add(next.end);
                    answer++;
                }
            }
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/155651
