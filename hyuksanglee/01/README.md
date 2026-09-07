# [PGS - Lv2] 01_디펜스 게임

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 우선순위 큐

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

* 힌트 수랑 라운드 수가 많아서 힌트 수마다 비교를 하는건 안될것이라고 판단
* 힌트를 나중에 계산하고 먼저 라운드 깰수 있는지 계산 
- 이후에 부족할경우 이전 값들에서 큰값에 힌트를 사용해서 그 수만큼 원상복구를 시켜준다.
- 갈수 있는 라운드를 계산해서 출력
   ```
   for(int e : enemy){
               int tmp = n-e;
               if(tmp<0 && k>0){
                   if(!que.isEmpty() && que.peek()>e){
                       n+=que.poll();
                       
                       n-=e;
                       que.add(e);
                   }
                   k--;
               }else if(tmp>=0){
                   n -= e;
                   que.add(e);
               }else{
                   break;
               }
               answer++;
           }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/142085?language=java
