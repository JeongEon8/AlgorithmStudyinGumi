# [PGS - Lv2] 02_n^2 배열 자르기

## ⏰**time**

30분

## :pushpin: **Algorithm**

- 구현
- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

   ```java
        for(int i = 0; i < N; i++){
            int row = (int) ((left + i) / n);
            int col = (int) ((left + i) % n);
            
            answer[i] = Math.max(row, col) + 1;
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/87390
