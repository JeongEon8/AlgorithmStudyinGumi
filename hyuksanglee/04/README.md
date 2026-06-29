# [PGS - Lv2] 04_서버 증설 횟수

## ⏰**time**

- 1시간

## :pushpin: **Algorithm**

- 큐

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

* 하루동안이라는 24시간이라는 고정이고 작은 수이기 때문에 이부분을 이용하면 되겠다고 생각함
1. 큐를 생성: 서버 남은 시간을 저장하기 위해
2. 현제 생성된 서버수와 필요한 서버수를 계산
3. 필요하다면 큐에 넣어주고 서버수도 증가시켜줌
4. 큐에서 현제시간과 서버시간을 비교해서 시간이 끝났으면 큐에서 제거하고 서버수도 줄여준다.
* 서버를 증가 시켜줄때마다 그 수를 저장하고 마지막에 출력
   ``` java
           for(int cur = 0; cur<players.length; cur++){
            
            while(!que.isEmpty() && que.peek().time <= cur){
                Server info = que.poll();
                serverCount -= info.count;
            }
            
            int size = que.size();
            int player = players[cur];
           
            int need = player/m;
            if(need>serverCount){
                int buy = need-serverCount;
                que.add(new Server(buy, cur+k));
                answer += buy;
                serverCount += buy;
            }
            
            
            
        }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/389479
