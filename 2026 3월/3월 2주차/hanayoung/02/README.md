# [백준 - S5] 1476. 날짜 계산

## ⏰  **time**
15분

## :pushpin: **Algorithm**
브루트포스, 정수론

## ⏲️**Time Complexity**
$O(1)$

## :round_pushpin: **Logic**
1. 연수를 확인할 i, 찾았는지 여부를 확인할 isRight, 체크중인 e,s,m을 담을 변수 선언
```java
        int i = 0;
        boolean isRight = false;
        int e = 0;
        int s = 0;
        int m = 0;
```
2. e, s, m이 E, S, M과 같아지면 탈출
3. E, S, M의 범위가 한정적이므로 e가 15가 되면 e = 1로 업데이트 아닐 경우 e++, s가 28이 되면 s = 1로 업데이트 아닐 경우 s++, m이 19일 경우 m = 1로 업데이트 아닐 경우 m++
4. 마지막으로 i 증가
```java
        while(true) {
            if(e == E && s == S && m == M) break;
            if(e == 15) e = 1;
            else e++;
            if(s == 28) s = 1;
            else s++;
            if(m == 19) m = 1;
            else m++;

            i++;
        }
```
5. 해당하는 i 출력
```java
System.out.println(i);
```


## :black_nib: **Review**
- 조금 더 효율적인 방법으로 풀어보려고 했으나 실버5라서 그런가 냅다 돌리기도 통과!..

## 📡 Link
https://www.acmicpc.net/problem/1476
