# [백준] 20164. 홀수 홀릭 호석 
 
## ⏰  **time**
1시간 

## :pushpin: **Algorithm**
브루트포스, 재귀 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
새로운 수가 나올 때마다 홀수의 수를 세어 주는 메서드(calculate)
...에서 한자리수, 두자리수, 세자리수이상 경우를 나눠서 본다.

한자리수
```java
        if (n < 10) {
            max = Math.max(max, newCount);
            min = Math.min(min, newCount);
            return;
        }
```

두자리수
```java
        if (n < 100) {
            int sum = plus(n); //각 자리 수 합하기 
            calculate(sum, newCount); //다시 호출 
            return;
        }
```

세자리수
```java
        //3덩어리로 나누기 
        for (int i = 1; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String part1 = numStr.substring(0, i);
                String part2 = numStr.substring(i, j);
                String part3 = numStr.substring(j);

                int num1 = Integer.parseInt(part1);
                int num2 = Integer.parseInt(part2);
                int num3 = Integer.parseInt(part3);

                //3덩어리 합 
                int sum = num1 + num2 + num3;

                //다시 호출
                calculate(sum, newCount);
            }
        }
```


## :black_nib: **Review**
- 로직을 떠올리는 것 자체는 나쁘지 않았으나, 재귀를 어디서 어떻게 해야 할지 조금 헤맨 문제였다. 

## 📡**Link**
- https://www.acmicpc.net/problem/20164
