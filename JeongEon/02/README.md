# [백준 - 실버 3] 9375. 패션왕 신해빈
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
조합, 맵

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 옷 종류 별로 맵에 넣는다.
2. 같은 종류가 들어오면 개수를 1 증가한다.
3. 종류별로 개수 + 1 한 값을 결과값에 곱한다.
4. 아무것도 안 입을 수 없으므로 1을 뺀다.
   ```cpp
		map<string, int> m;
		for (int j = 0; j < nn; j++) {
			string s1; cin >> s1;
			string s2; cin >> s2;
			m[s2]++;
		}
		
		int sum = 1;
		for (auto x : m) {
			sum *= x.second + 1;
		}

		cout << sum - 1 << "\n";
   ```

## :black_nib: **Review**
- 뭔가 간단하면서 어렵게 가면 어려워지는 문제...

## 📡 Link
https://www.acmicpc.net/problem/9375
