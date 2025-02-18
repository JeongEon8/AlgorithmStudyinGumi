# [백준] 2195. 문자열 복사


## ⏰ **time**
30분

## :pushpin: **Algorithm**
그리디 알고리즘, 문자열

## ⏲️**Time Complexity**
O(S.length() × P.length()) 

## :round_pushpin: **Logic**
문자열 S, P에서 겹치는 부분을 몇 덩어리로 자를 수 있는지 생각하면 된다. <br/>
일치하는 부분부터 시작해서 최장길이 뽑아내고 자르고 다시 뽑아내고...
```java
            // S에서 P[pIndex]와 일치하는 부분 탐색
            for (int start = 0; start < S.length(); start++) {
                int currentLength = 0;

                // 부분 문자열이 일치하는 최대 길이 계산
                while (start + currentLength < S.length() &&
                        pIndex + currentLength < P.length() &&
                        S.charAt(start + currentLength) == P.charAt(pIndex + currentLength)) {
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
```


## :black_nib: **Review**
나쁘지 않은 골드5 문제... 

## 📡**Link**
https://www.acmicpc.net/problem/2195
