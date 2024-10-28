# [백준 - 실버 5] 31738. 매우 어려운 문제
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. N > M 이면 나누어 떨어지는 게 한개라도 있을 것이니 0이다.
2. else -> i곱하고 M나눈 나머지를 반복한다.
   ```cpp
	if (N > M) {
		cout << 0;
	}
	else {
		long long result = 1;
		for (long long  i = 1; i <= N; i++) {
			result *= i;
			result %= M;
		}

		cout << result << endl;
	}
   ```

## :black_nib: **Review**
- 어렵다! 에드혹! 다신 안해야지~~
- 
## 📡 Link
https://www.acmicpc.net/problem/31738
