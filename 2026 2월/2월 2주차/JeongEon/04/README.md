# [백준 - 실버 3] 14494.다이나믹이 뭐예요?

## ⏰ **time**
10분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N^M)$

## :round_pushpin: **Logic**
1. 오른쪽 `[i][j-1]`, 아래 `[i-1][j]`, 대각선`[i-1][j-1]`
```cpp
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			DP[i][j] = (DP[i - 1][j] + (DP[i][j - 1] + DP[i - 1][j - 1]) % 1000000007) % 1000000007;
		}
	}
```

## :black_nib: **Review**
- [10 Hours Of Wii Theme Music (Mii Song)](https://www.youtube.com/watch?v=Twi92KYddW4&list=RDTwi92KYddW4&start_radio=1&t=2961s) 요새 알고 풀 때 닌텐도 노래 들으면 잘 풀리는 거 같아요
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/14494](https://www.acmicpc.net/problem/14494)
