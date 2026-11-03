# [PGS - Lv2] 01_힌트 스테이지

## ⏰**time**

- 1시간

## :pushpin: **Algorithm**

- dfs

## ⏲️**Time Complexity**

$O(2^N * M)$ 

## :round_pushpin: **Logic**

1. 스테이지마다 힌트를 살지 말지 고르면 되서 총 경우의 수는 2^16 이된다.
 - 완탐해도 시간 초과 안날거라 생각해서 dfs 사용
   ```
   tatic void dfs(int step, int total, int[] count){
           if(step == len){
               answer = Math.min(answer, total);
               return;
           }
            int use = Math.min( count[step + 1], cost[step].length - 1 );
           
           int stageCost = cost[step][use];
           
           dfs(step+1, total+ stageCost, count);
           if (step < hint.length) {
               for(int j = 1; j<hint[step].length; j++){
                   count[hint[step][j]]++;    
               }
           
               dfs( step + 1, total + stageCost + hint[step][0], count );
   
               for(int j = 1; j<hint[step].length; j++){
                   count[hint[step][j]]--;    
               }
           }
           
           
       }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/468377
