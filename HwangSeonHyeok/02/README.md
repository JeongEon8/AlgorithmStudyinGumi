# [백준 - S5] 20546. 🐜 기적의 매매법 🐜

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
bnp는 항상 잔금이 판매가보다 많으면 사면 되고 타이밍 매매법은 3번 연속 상승하면 모든 주식을 팔고 3번 이상 하향하면 구매할 수 있다면 항상 모든 돈으로 주식을 산다.
```java
if (firstPrice <= bnpMoney) {
    bnpStock += bnpMoney / firstPrice;
    bnpMoney -= firstPrice * (bnpMoney / firstPrice);
}
for (int i = 1; i < 14; i++) {
    int currentPrice = arr[i];
    if (currentPrice <= bnpMoney) {
        bnpStock += bnpMoney / currentPrice;
        bnpMoney -= currentPrice * (bnpMoney / currentPrice);
    }
    if (currentPrice == arr[i - 1])
        timingTrend = 0;
    else if (currentPrice < arr[i - 1]) {
        timingTrend = Math.min(-1, timingTrend - 1);
    } else if (currentPrice > arr[i - 1]) {
        timingTrend = Math.max(1, timingTrend + 1);
    }
    if (timingTrend >= 3) {
        timingMoney += timingStock * currentPrice;
        timingStock = 0;
    } else if (timingTrend <= -3) {
        timingStock += timingMoney / currentPrice;
        timingMoney -= currentPrice * (timingMoney / currentPrice);
    }
}
```
## :black_nib: **Review**
기적의 매매법🐜🐜
## 📡**Link**

https://www.acmicpc.net/problem/20546