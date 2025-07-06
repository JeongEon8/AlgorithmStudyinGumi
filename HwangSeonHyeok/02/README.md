# [백준 - S3] 2659. 십자카드 문제

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 브루트포스 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
입력받은 4개의 수로 시계수가 될 수 있는 수 4개를 비교해서 가장 작은 시계수를 구한다  
1111~9999를 돌면서 몇 번째 시계수인지 구한다.
```java
static int getClockNum(int a, int b, int c, int d) {
    int num1 = a * 1000 + b * 100 + c * 10 + d;
    int num2 = b * 1000 + c * 100 + d * 10 + a;
    int num3 = c * 1000 + d * 100 + a * 10 + b;
    int num4 = d * 1000 + a * 100 + b * 10 + c;
    return Math.min(num1, Math.min(num2, Math.min(num3, num4)));
}
int clock = getClockNum(a, b, c, d);
for (int i = 1111; i <= clock; i++) {
    int a2 = i / 1000;
    int b2 = (i / 100) % 10;
    int c2 = (i / 10) % 10;
    int d2 = i % 10;
    if (a2 == 0 || b2 == 0 || c2 == 0 || d2 == 0)
        continue;
    if (i == getClockNum(a2, b2, c2, d2)) {
        ans++;
    }
}
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2659