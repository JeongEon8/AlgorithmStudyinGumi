# [PGS - LV2] 12914. 멀리 뛰기

## ⏰ **time**

3분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
0칸에 가는 경우가 fibo(1)인 피보나치 문제.
```java
public long solution(int n) {
    int current = 1;
    int p = 0;
    int pp = 0;
    for(int i = 1; i<=n; i++){
        pp = p;
        p = current;
        current = (p + pp)%1234567;
    }
    return current;
}
```

## :black_nib: **Review**
우연찮게 똑같은 피보나치 문제..
## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12914