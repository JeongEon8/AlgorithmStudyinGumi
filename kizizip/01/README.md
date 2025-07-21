# [백준 - S4] 3036. 링

## ⏰ **time**
10분

## :pushpin: **Algorithm**
수학, 유클리드 호제법

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1. 각 링의 길이를 arr에 저장한다.
2. 기준이 되는 링과 비교 링의 길이의 최대공약수 num을 구하는데, 유클리드 호제법을 이용한다.
   ```java
       public static int cal(int a, int b) {
        while (b != 0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
   ```
3. num으로 분자, 분모 나눠서 출력한다...


## :black_nib: **Review**  
쉬워요~

## 📡**Link**
https://www.acmicpc.net/problem/3036 
