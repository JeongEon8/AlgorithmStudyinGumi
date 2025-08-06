
# [백준- G5] 14719. 빗물

## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
O(N^2)

## :round_pushpin: **Logic**
- (1 ~ W-1) 범위에 대해서 왼쪽 기준 제일 높을 때와 오른쪽 기준 높을 때를 구해서 낮은 높이를 기준으로 물이 고인 것을 계산 할 수 있음

```java
for(int j = 0; j < i; j++) {
	leftMax = Math.max(leftMax, list[j]);
}

for(int j = i+1; j < W; j++) {
	rightMax = Math.max(rightMax, list[j]);
}

int water = Math.min(leftMax, rightMax) - list[i];

```

## :black_nib: **Review**
어렵게 생각했던거에 비해 쉽게 풀렸습니다.

## 📡**Link**
- https://www.acmicpc.net/problem/14719

