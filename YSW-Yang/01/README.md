# [PGS - Lv2] 01_2개 이하로 다른 비트

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 비트마스킹
- 비트 연산

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 짝수는 마지막 비트가 0이므로 1을 더하면 마지막 비트만 1로 변경되어 조건을 만족한다.
홀수는 마지막 비트가 1이므로 +1만으로는 2개 이상의 비트가 변경될 수 있다. 따라서 가장 오른쪽의 0을 1로, 그 바로 오른쪽의 1을 0으로 변경해야 한다.
~num & (num + 1)을 이용해 가장 오른쪽의 0 비트를 찾고 (num | lastZero)로 해당 비트를 1로 만든 뒤 & ~(lastZero >> 1)을 통해 바로 오른쪽의 1 비트를 0으로 변경한다.
   ```java
        for(int i = 0; i < N; i++){
            long num = numbers[i];
            
            if(num % 2 == 0){
                answer[i] = num + 1;
            }else{
                long lastZero = ~num & (num + 1);
                answer[i] = (num | lastZero) & ~(lastZero >> 1);
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=java
