# [백준 - S2] 28138. 재밌는 나머지 연산

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정수론

## ⏲️**Time Complexity**

$O(\sqrt{N})$

## :round_pushpin: **Logic**
$N = k * m + R$라고 하면 $N-R = k*m$이므로 N-R을 나눠서 나머지가 0인 수들의 합을 구하면된다.
```java
long diff = n - r;
for (long i = 1; i * i <= diff; i++) {
    if (diff % i == 0) {
        long tmp = diff / i;
        if (i > r) {
            ans += i;
        }
        if (i != tmp) {
            if (tmp > r) {
                ans += tmp;
            }
        }
    }
}
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/28138