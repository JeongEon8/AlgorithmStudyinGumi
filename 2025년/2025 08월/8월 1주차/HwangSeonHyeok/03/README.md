# [백준 - S5] 28464. Potato

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
감자튀김의 양을 정렬하고 박모씨는 많은 접시부터, 성우는 적은 접시부터 먹으면된다.
```java
while (parkIdx >= sungIdx) {
    park += arr[parkIdx--];
    if (parkIdx < sungIdx)
        break;
    sung += arr[sungIdx++];
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/28464
