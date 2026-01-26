# [백준 - S4] 1065. 한수

## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현, 수학

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. 1부터 N까지 반복하며, 100보다 작을 경우는 무조건 등차수열을 이루므로 answer++
2. 100보다 크거나 같을 경우 마지막 자릿수와 그 앞 자릿수와의 차이를 저장해두고 같은지 계속 확인.
3. check값을 10으로 나눠가며, 10으로 나눈 값이 0보다 클 때까지 반복. 만약 같지 않다면 탈출
4. check/10이 0이면 끝까지 탐색한 것이므로 answer++
```java
        for(int i = 1; i <= N; i++) {
            if(i < 100) {
                answer++;
            } else {
                int check = i/10;
                int diff = (i/10)%10 - i % 10;
                while(check/10 > 0) {
                    if((check/10) % 10 - check % 10 == diff) {
                        check /= 10;
                    }
                    else break;
                }
                if(check/10 == 0) answer++;
            }
        }
```

## :black_nib: **Review**
- while문 조건을 잘못 걸어서 조금 돌아갔고 한 자릿수와 그 다음 자릿수와의 차이를 저장하고 나누고 하는 게 약간 헷갈렸음..!

## 📡 Link
https://www.acmicpc.net/problem/1065
