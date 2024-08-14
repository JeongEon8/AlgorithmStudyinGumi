# [백준] 10158. 개미 
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
수학, 애드 혹, 사칙연산 

## ⏲️**Time Complexity**
124ms

## :round_pushpin: **Logic**
1. 제한시간이 매우 짧으므로 Scanner 대신 BufferedReader를 사용한다.

2. 최초의 개미 좌표에 t만큼 추가하여 p, q값을 갱신한다.

3. 왕복 횟수를 구함으로써 개미의 이동 방향을 파악한다. 이 작업에 왕복 횟수 소수점은 필요하지 않으므로 int값으로 만들었다.
4. 왕복 횟수(count)가 짝수라면 우측/상향으로 이동, 홀수라면 좌측/하향으로 이동하는 것이다.
```java
       int countX = p/w; //몇 번 왕복하는 중인지
       int countY = q/h;
       
       if (countX%2 == 0) {
           p = p%w;
       } else {
           p = w - (p%w);
       }
       
       if (countY%2 ==0) {
           q = q%h;
       } else {
           q = h - (q%h);
       }
```

5. 시간 단축을 위해 StringBuilder를 이용하여 출력한다.

## :black_nib: **Review**
- 로직 구상이 쉬울 줄 알았는데 어려웠다. 수학적 사고력을 길러보도록 하자.
- StringBuilder랑 서먹하다. 

## 📡**Link**
- https://www.acmicpc.net/problem/10158
