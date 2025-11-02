# [백준 - S5] 14490. 백대열

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 문자열
- 정수론


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
문자열을 파싱하고 둘 중 더 작은 값에서 1까지 줄여가면서 나누어 지는경우를 찾는다.
```java
String[] split = str.split(":");
int a = Integer.parseInt(split[0]);
int b = Integer.parseInt(split[1]);
int small = Math.min(a, b);
for (; small >= 1; small--) {
    if (a % small == 0 && b % small == 0) {
        break;
    }
}
```

## :black_nib: **Review**
GCD로 최대공약수 구하는 문제 같은데 TLE 안나고 풀리긴 했다.
## 📡**Link**

https://www.acmicpc.net/problem/14490