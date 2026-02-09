# [백준 - S5] 1193. 분수찾기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 초기값 설정. idx는 현재 가리키는 분수의 번호 의미, sum은 한 대각선 줄에서의 합계
```java
        int idx = 1;
        int sum = 3;
        String answer = "";
```
2. X가 1이라면 바로 1/1 answer에 담기
```java
        if(X == 1) answer = "1/1";
```
4. X가 1보다 클 경우 idx가 X와 같아질 때까지 반복
5. 합계가 짝수일 경우 분자가 분모보다 더 큰 것부터 시작되므로 sum-1부터 하나씩 줄여가며 idx를 증가시켜 X와 같아질 때까지 반복
6. idx와 X가 같으면 answer를 i+"/"+(sum-i) 로 업데이트
7. 합계가 홀수일 경우 분자가 분모보다 더 작은 것부터 시작되므로 1부터 증가시키며 idx가 X와 같아질 때까지 반복 후 동일하게 업데이트
8. sum 한 바퀴 돌고 sum++
```java
            while(idx <= X) {
                if(sum % 2 == 0) {
                    for(int i = sum-1; i > 0; i--) {
                        idx++;
                        if(idx == X) {
                            answer = i+"/"+(sum-i);
                            break;
                        }
                    }
                } else {
                    for(int i = 1; i < sum; i++) {
                        idx++;
                        if(idx == X) {
                            answer = i+"/"+(sum-i);
                            break;
                        }
                    }
                }
                sum++;
            }
```

## :black_nib: **Review**
- 다른 문제들보다 더 이해하기가 어려웠던 문제..! 지그재그로 움직이는게 뭔디...!

## 📡 Link
https://www.acmicpc.net/problem/1193
