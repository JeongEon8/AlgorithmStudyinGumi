# [PGS - Lv2] 02_피로도

## ⏰**time**

46분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

- 크기가 8이라서 하나씩 탐색해도 된다고 생각이 들었고 bfs를 활용하여 하나씩 탐색하고 개수 최댓값을 뽑아주는 식으로 구했음
   ```java
   while (!que.isEmpty()) {
            Info data = que.poll();
            int currentBit = data.bit;
            int currentK = data.k;
            
            if (answer < data.count) {
                answer = data.count;
            }
            
            for (int j = 0; j < len; j++) {
                int newMin = dungeons[j][0];
                int newPrice = dungeons[j][1];
                
                if ((currentBit & (1 << j)) == 0 && currentK >= newMin && currentK - newPrice >= 0) {
                    
                    que.add(new Info(currentK - newPrice, currentBit | (1 << j), data.count + 1));
                    
                }
            }
   ```

## :black_nib: **Review**

- 오랜만에 풀어서 그런지 왜이리 없었지

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/87946
