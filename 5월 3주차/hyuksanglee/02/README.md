# [PGS - Lv2] 02_기능개발

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 남은 퍼센트와 처리할수 있는 스피드를 변수로 저장
   ```java
            int progresse = progresses[i];
            int speed = speeds[i];
   ```
2. 남은 작업을 하는데 걸리는 일 구하기 
   ```java
            int result = total/speed; 
            if(total%speed >0) result += 1;
   ```
- 이렇게 하는 이유: 70에서 /30 을 하면 2.33 정도 나오는데 이걸 올림 처리를 위해 나머지가 1이상일경우 1을 더해준다.
3. 이전값이 작업 시간이 짧으면 카운터 숫자를 늘려주고 크면 list에 넣어주고 카운트 초기화 해줌
   ```java
             if(min< result){
                    min = result;
                    list.add(count);
                    count = 1;
                    index = i;
                }else{
                    count++;
                }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42586
