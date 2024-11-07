# [백준 - 실버 5] 16212. 정열적인 정렬
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
sort를 이용한다.
   ```cpp
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		vec.push_back(input);
	}

	sort(vec.begin(), vec.end());
   ```

## :black_nib: **Review**
- sort

## 📡 Link
https://www.acmicpc.net/problem/16212
