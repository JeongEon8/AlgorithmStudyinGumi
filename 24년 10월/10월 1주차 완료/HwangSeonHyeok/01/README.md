# [백준 - S4] 1246. 온라인 판매

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

고객들을 비싸게 살 수 있는 순으로 정렬하고 1명~ n명까지 팔 수 있는 가격과 총 수입을 개산해서 수입이 최대가 되는 가격과 수익을 출력하면된다.

```java
	Collections.sort(pList,Collections.reverseOrder());
	int ans = 0;
	int ansprice = 0;
	for(int i = 0;i<m; i++) {
		if(i==n)break;
		int tmp = Math.min(i+1,n) * pList.get(i);
		if(tmp>=ans) {
			ansprice = pList.get(i);
			ans = tmp;
		}
	}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1246
