# [백준 - S4] 1487. 물건팔기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 브루트포스

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

최대 50명이므로 각 사람들의 원하는 가격마다 모두에게 살 사람이고 그사람에게 팔때 이윤이 남는지를 판단해서 최대 수익을 계산한다. 최대 수익이 여러 가격이면 더 낮은 가격이 답이되게한다.

```java
int ans = 0;
int maxbenefit = 0;
for(int i = 0; i<n; i++) {
	int price = customerArr[i].price;
	int benefit = 0;
	for(int j = 0; j<n;j++) {
		Customer customer = customerArr[j];
		if(price<=customer.price&&price>customer.fee) {
			benefit+=price-customer.fee;
		}
	}
	if(maxbenefit<benefit||(maxbenefit==benefit&&price<ans)) {
		maxbenefit = benefit;
		ans = price;
	}
}

```

## :black_nib: **Review**

이익이 같으면 가장 작은가격을 출력하는 조건을 못봤다..

## 📡**Link**

https://www.acmicpc.net/problem/1487
