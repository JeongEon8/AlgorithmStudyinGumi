# [백준 - S1] 14232. 보석 도둑

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정수론
- 소수 판정
- 에라토스테네스의 체
- 소인수분해

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
보석들을 최대한 많이 가지고 나오려면 소인수 분해로 소수수의 곱으로 만들면된다.
```java
List<Long> list = new ArrayList<>();
for (long i = 2; i * i <= n; i++) {
    while (n % i == 0) {
        list.add(i);
        n /= i;
    }
}
if (n > 1)
    list.add(n);
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/14232