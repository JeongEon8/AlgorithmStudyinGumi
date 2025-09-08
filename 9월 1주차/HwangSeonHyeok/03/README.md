# [백준 - S3] 2685. 님비합 

## ⏰ **time**

35분

## :pushpin: **Algorithm**

- 수학
- 구현
## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
진법 변환하면서 바로 님비합을 바로 구한다.
```java
static long nimBSum(long B, long X, long Y) {
    long result = 0;
    long tmp = 1;
    while (X > 0 || Y > 0) {
        long xb = X % B;
        long yb = Y % B;
        long digit = (xb + yb) % B;
        result += tmp * digit;
        X /= B;
        Y /= B;
        tmp *= B;
    }
    return result;
}
```

## :black_nib: **Review**
문제를 이해하는데 어려웠다.
## 📡**Link**

https://www.acmicpc.net/problem/2685