# [PGS - Lv2] 02_124 나라의 숫자

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**

1. 0이 없는 3진법을 구현하는 문제였다. 일반 3진법은 0, 1, 2를 사용하지만 124 나라는 1, 2, 4를 사용한다. 따라서 나머지가 1이면 1, 2면 2, 0이면 4로 변환한다. 또한 나머지가 0인 경우에는 자릿수 올림이 발생하므로 n = n / 3 - 1로 몫을 하나 줄여 다음 자릿수를 계산한다.
   ```java
        while(n > 0){
            int r = n % 3;
            
            if(r == 0){
                sb.append("4");
                n = n / 3 - 1;
            }else if(r == 1){
                sb.append("1");
                n /= 3; 
            }else{
                sb.append("2");
                n /= 3;
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12899
