# [PGS - Lv2] 01_연속 부분 수열 합의 개수

## ⏰**time**

40분

## :pushpin: **Algorithm**

- 완전탐색
- Set

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
elements 배열을 각 자리에서 시작해서 연속된 부분수열의 합을 만들어서 Set에 저장해서 답을 구했다.

   ```java
           for(int i = 0; i < n; i++){
            int currentSum = 0;
            for(int j = 0; j < n; j++){
                currentSum += elements[(i + j) % n];
                
                uniqueSums.add(currentSum);
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/131701
