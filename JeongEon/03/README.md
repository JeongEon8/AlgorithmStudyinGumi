# [백준 - S2] 6603. 로또

## ⏰  **time**
25분

## :pushpin: **Algorithm**
백트래킹

## ⏲️**Time Complexity**
$O(n^2)$

## :round_pushpin: **Logic**
1. 백트래킹을 통해 반복해서 수 바꾸기 및 depth가 6이 되면 출력
```cpp
void getCombi(int start, int depth) {
	if (depth == 6) {
		for (int i = 0; i < 6; i++) {
			cout << lotto[i] << " ";
		}
		cout << '\n';
		return;
	}
	
	for (int i = start; i < k; i++) {
		lotto[depth] = S[i];
		getCombi(i + 1, depth + 1);
	}
}
```

## :black_nib: **Review**
- 독일은 로또 번호가 6자리구나

## 📡 Link
https://www.acmicpc.net/problem/6603
