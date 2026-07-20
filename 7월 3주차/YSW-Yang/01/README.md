# [PGS - Lv2] 01_마법의 엘리베이터

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 일의 자리부터 왼쪽 자릿수로 이동하며 값을 판별합니다.
2. 현재 자릿수 > 5 이면 올림
3. 현재 자릿수 < 5 이면 내림
4. 현재 자릿수 == 5 이면 다음 자릿수가 5 이상이면 올림, 5 미만이면 내림
5. 숫자가 0이 될 때까지 이를 반복합니다.
   ```java
        while(storey > 0){
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            
            if(cur > 5){
                answer += 10 - cur;
                storey += 10;
            }else if(cur == 5){
                if(next >= 5){
                    answer += 10 - cur;
                    storey += 10;
                }else{
                    answer += cur;
                }
            }else{
                answer += cur;
            }
            storey /= 10;
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/148653?language=java
