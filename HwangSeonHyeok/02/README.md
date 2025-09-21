# [백준 - S5] 30648. 트릭 플라워

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**
조건대로 좌표를 바꿔가면서 지나간 좌표를 bolean 배열에 기록하고 방문했던 좌표를 다시 방문하면 정지한다.

```java
while (true) {
    ans++;
    if (a + b + 2 < r) {
        a++;
        b++;
    } else {
        a /= 2;
        b /= 2;
    }
    if (flowers[a][b])
        break;
    flowers[a][b] = true;
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/30648