# [PGS - Lv2] 02_연속 부분 수열 합의 개수

## ⏰**time**

- 30분 

## :pushpin: **Algorithm**

- set
- 수열

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. set을 이용해서 중복값을 계산안하려고 했고 첫번째 자리 부터 하나씩 계산해서 셋에 넣어줌
2. 셋 개숫를 반환
   ```
   Set<Long> set = new HashSet();
           int len = elements.length;
           
           for(int i = 0; i<len; i++){
               long total =0;
               for(int j = 0; j<len; j++){
                   total += elements[(i + j) % len];
                   set.add(total);
               }
           }
   ```

## :black_nib: **Review**



## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/131701
