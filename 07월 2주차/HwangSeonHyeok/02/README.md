# [백준 - S5] 5347. LCM

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 정수론
- 유클리드 호제법

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
a와 b의 최소 공배수는 a*b/(a와b의최대공약수) 이다.  
유클리드 호제법으로 최대공약수를 구해서 최소 공배수를 계산한다.
```java
static long gcd(long a, long b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}
for (int i = 0; i < n; i++) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long ans = a * b / gcd(a, b);
    sb.append(ans).append("\n");
}
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/5347