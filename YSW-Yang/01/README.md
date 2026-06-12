# [PGS - Lv2] 01_숫자 변환하기

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- BFS

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

   ```java
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            
            if(cur[0] == y){
                return cur[1];
            }
            
            if(cur[0] + n <= y && !visited[cur[0] + n]){
                queue.add(new Integer[] {cur[0] + n, cur[1] + 1});
                visited[cur[0] + n] = true;
            }
            if(cur[0] * 2 <= y && !visited[cur[0] * 2]){
                queue.add(new Integer[] {cur[0] * 2, cur[1] + 1});
                visited[cur[0] * 2] = true;
            }
            if(cur[0] * 3 <= y && !visited[cur[0] * 3]){
                queue.add(new Integer[] {cur[0] * 3, cur[1] + 1});
                visited[cur[0] * 3] = true;
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154538?language=java
