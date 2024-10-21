# [백준 - 실버 5] 14912. 숫자 빈도수
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 1부터 n까지 숫자를 문자열로 바꿔서 확인한다.
2. 자리수 마다 확인하며 d랑 같은지 확인한다.
3. 같다면 cnt++를 한다.
4. cnt 를 결과로 출력한다.
   ```cpp
	for (int i = 1; i <= n; i++) {
		string temp = to_string(i);
		for (char j : temp) {
			if (j - '0' == d) {
				cnt++;
			}
		}
	}
   ```

## :black_nib: **Review**
- 시간초과날거 같았지만 실버 5라서 가능했다.

## 📡 Link
https://www.acmicpc.net/problem/14912
