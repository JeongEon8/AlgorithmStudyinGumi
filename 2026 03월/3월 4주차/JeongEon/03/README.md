# [백준 - 실버 2] 15988. 1, 2, 3 더하기 3

## ⏰ **time**
16분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. DP[1] = 1, DP[2] = 2, DP[3] = 4
2. `DP[i] = DP[i-1] + DP[i-2] + DP[i-3]`
3. top에 역대 가장 컸던 n을 저장한다.
4. top보다 작은 n을 입력받으면 출력하고
5. top보다 큰 n을 입력 받으면 for을 돌며 DP 계산 후 출력한다.

```cpp
		if (n <= top) {
			cout << DP[n] % 1000000009 << '\n';
		}
		else {
			for (int i = top + 1; i <= n; i++) {
				DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3])% 1000000009 ;
			}
			top = n;
			cout << DP[n] % 1000000009 << '\n';
		}
```

## :black_nib: **Review**
- 1000000009 사이즈나 되는데, `long long` 자료형으로 안한고 `int`로 해서 4번이나 틀렸어요.
- 난 왕 바보야ㅠ

## 📡 Link
[https://www.acmicpc.net/problem/15988](https://www.acmicpc.net/problem/15988)
