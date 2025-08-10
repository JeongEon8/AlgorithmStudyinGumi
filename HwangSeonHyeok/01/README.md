# [백준 - S2] 12993. 이동3

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 수학
- 그리디 알고리즘
- 정수론

## ⏲️**Time Complexity**

$O(logN)$

## :round_pushpin: **Logic**
각 수를 3진수로 바꾸면 어떤 3^k의 합으로 만들 수 있는지 알 수 있다. 3진수의 각자리들은 두 수를 합쳐서 1번씩만 나와야 이동이 가능한 좌표이다.
```java
while (isAble && (x > 0 || y > 0)) {
    int remainX = x % 3;
    int remainY = y % 3;
    if (remainX + remainY == 1) {
        x /= 3;
        y /= 3;
    } else {
        isAble = false;
    }
}
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/12993
