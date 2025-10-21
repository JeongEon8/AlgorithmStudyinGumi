# [백준 - S1] 25947. 선물확인 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬
- 누적 합

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

먼저 N개의 선물을 가격을 기준으로 오름차순 정렬한다.
그리고 첫 번째 선물부터 A개의 선물을 반값에 구매하며 가격을 누적시킨다.
만약 반값에 구매하는 도중에 예산을 넘어버리면 구매를 종료한다.
A개의 선물을 반값에 구매해도 예산이 넘지 않는다면 그 다음 선물을 반값에 구매하며 첫 번째 선물부터 원래 가격으로 다시 구매한다.
원래 가격으로 다시 구매할 선물의 절반의 가격만큼 예산을 추가로 누적하면 해당 선물은 원래 가격으로 구매한 것이 된다.
이렇게 마지막 선물까지의 가격을 확인하면 예산이 넘지 않는 선에서 구매할 수 있는 선물의 최대 개수를 구할 수 있다.

```java
		for (int i = 0; i < n; i++) {
			long halfPrice = asendingPrice[i] / 2;
			if (count < numberOfDiscount) {
				if (budget >= halfPrice) {
					budget -= halfPrice;
					count++;
				} else {
					break;
				}
			} else {
				if (budget >= halfPrice + asendingPrice[index] / 2) {
					budget -= (halfPrice + asendingPrice[index] / 2);
					index++;
					count++;
				} else {
					break;
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25947
