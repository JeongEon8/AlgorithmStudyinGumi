# [PGS - Lv2] 03_피로도

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- dfs

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. dfs를 사용해서 라운드마다 각각 탐색함
   ```
   public void dfs(int depth){
           if(depth>max){max = depth;}
           
           for(int i = 0; i<dungeons.length; i++){
               if(check[i]){
                   continue;
               }
               int need = dungeons[i][0];
               int send = dungeons[i][1];
               if(need<=k){
                   k-=send;
                   check[i]=true;
                   dfs(depth+1);
                   check[i]=false;
                   k+=send;
               }
           }
       }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
