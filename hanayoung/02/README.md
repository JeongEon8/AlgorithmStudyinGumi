# [백준 - S5] 14916. 거스름돈

## ⏰  **time**
20분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(1)$

## :round_pushpin: **Logic**
1. 불가능한 경우인, 금액이 1이거나 3인 경우는 -1로 출력
```java
if(n == 1 || n == 3) System.out.println(-1);
```
2. answer는 동전 개수를 의미, rem은 동전 개수로 계산되지 않은 돌려줘야 할 남은 금액, 가능한 최대치로 5원으로 나눠 주고 남은 금액과 동전의 개수를 현재 의미
```java
            int answer = n / 5; 
            int rem = n % 5; 
```
3. 남은 금액이 2원으로 처리가 가능하지 않다면(rem % 2 값이 0이 아니면) 5원을 하나 더 꺼내고, 5원을 꺼낸 값이 여전히 나눠지지 않는다면 5원을 하나 더 꺼내서 2원짜리로 계산.
4. 2원으로 처리 가능했다면 answer에 rem/2 개수 더하기
```java
            if(rem % 2 != 0) {
                if((rem + 5) % 2 == 0) {
                    answer -= 1;
                    answer += (rem + 5) / 2;
                } else {
                    answer -= 2;
                    answer += (rem + 10) / 2;
                }
            } else {
                answer += rem / 2;
            }
            System.out.println(answer);
```


## :black_nib: **Review**
- 계산으로 해결 !

## 📡 Link
https://www.acmicpc.net/problem/14916
