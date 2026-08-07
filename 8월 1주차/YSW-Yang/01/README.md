# [PGS - Lv2] 01_서버 증설 횟수

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 우선순위 큐

## ⏲️**Time Complexity**

$O(NlogN)$ N은 players 길이

## :round_pushpin: **Logic**

1. 
   ```java
        int currentServerCount = 0;
        for(int i = 0; i < players.length; i++){
            if(!pq.isEmpty() && pq.peek().endTime == i){
                currentServerCount -= pq.poll().serverCount;
            }
            
            int needServerCount = players[i] / m - currentServerCount;
            if(needServerCount > 0){
                pq.add(new Server(needServerCount, i + k));
                currentServerCount += needServerCount;
                answer += needServerCount;
            }

        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/389479?language=java
