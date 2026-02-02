# [백준 - S3] 31883. FA수의 진

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 구현
- 그리디 알고리즘
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
매 구간마다 신호등을 기다렸다 건너는게 빠른지 육교로 건너는게 빠른지 비교해서 더 빠른 코스를 선택하면된다.
```java
static int waitTime(int current, int green, int red) {
    int cycle = green + red;
    int t = current / cycle;
    int prevTime = cycle * t;
    if (prevTime + green > current) {
        return 0;
    } else {
        return prevTime + cycle - current;
    }

}

for (int i = 0; i < n; i++) {
    int totalSignalTime = signal[i] + waitTime(ans, green[i], red[i]);
    if (totalSignalTime > bridge[i]) {
        ans += bridge[i];
    } else {
        ans += totalSignalTime;
    }
}
```
## :black_nib: **Review**
그리디 조아

## 📡**Link**
https://www.acmicpc.net/problem/31883