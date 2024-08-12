# [백준 - 실버5] 4673. 셀프 넘버
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
1. 1부터 9999의 수를 본인과 각 자리수를 더해서 해당 결과값을 배열의 위치로 사용한다.
2. 그 위치의 배열 값을 +1 한다.
3. 배열 전체를 돌며 배열값이 0인 경우의 위치를 출력한다.
```cpp
	for (int num = 1; num < 10000; num++) {
		string temp = to_string(num);
		int ptr = num;
		for (int i = 0; i < temp.length(); i++) {
			ptr += temp[i] - '0';
		}
		if (ptr > 10000) {
			continue;
		}
		arr[ptr]++;
	}

	for (int i = 1; i < 10000; i++) {
		if (arr[i] == 0) {
			cout << i << "\n";
		}
	}
```

## :black_nib: **Review**
- 야호 짱 쉬웡 후헤헤

## 📡 Link
https://www.acmicpc.net/problem/4673
