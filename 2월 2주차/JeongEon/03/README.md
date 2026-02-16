# [백준 - 실버 1] 11052.카드 구매하기

## ⏰ **time**
40분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. DP 배열에 저장되는 값은 i개의 카드를 살 떄 최대 가격이다.
2. `P[0] + DP[N]`, `P[1] + DP[N-1]`, ... `P[N] + DP[0]` 가격 중 가장 큰 값을 DP[N]에 저장한다.
```cpp
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			DP[i] = DP[i] < DP[i - j] + P[j] ? DP[i - j] + P[j] : DP[i];
		}
	}
```

## :black_nib: **Review**
- [10 Hours Of Wii Theme Music (Mii Song)](https://www.youtube.com/watch?v=Twi92KYddW4&list=RDTwi92KYddW4&start_radio=1&t=2961s) 요새 알고 풀 때 닌텐도 노래 들으면 잘 풀리는 거 같아요
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/11052](https://www.acmicpc.net/problem/11052)
