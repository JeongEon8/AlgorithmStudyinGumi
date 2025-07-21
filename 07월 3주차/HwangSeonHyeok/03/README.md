# [백준 - S3] 29718. 줄줄이 박수

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 누적 합
- 슬라이딩 윈도우
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각열의 박수 횟수들을 기록해두고 슬라이딩 윈도우로 가장 박수 횟수가 많은 연속 구간을 구한다.
```java
int idx = 0;
int max = 0;
int sum = 0;
for (int i = 0; i < a; i++) {
    sum += claps[i];
}
max = sum;
for (int i = 0; i < m - a; i++) {
    sum -= claps[i];
    sum += claps[i + a];
    if (max < sum) {
        max = sum;
    }
}
```

## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/29718
