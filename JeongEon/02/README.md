# [백준 - 골드5] 12919. A와 B 2
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
백트레킹(재귀)

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. result 맨 뒤가 A면 없애고
2. 맨 앞이 B면 제거 후 reverse
```cpp
void addAB(string arr, string result) {
	if (arr == result) {
		cout << "1\n";
		exit(0);
	}

	if (arr.length() >= result.length()) {
		return;
	}

	if (result[result.length() - 1] == 'A') {
		temp = result;
		temp.erase(temp.length() - 1);
		addAB(arr, temp);
	}

	if (result[0] == 'B') {
		temp = result;
		temp.erase(temp.begin());
		reverse(temp.begin(), temp.end());
		addAB(arr, temp);
	}
}
```

## :black_nib: **Review**
- 엇.. 생각보다 안풀렸다. 감을 좀 잡아야겠다.

## 📡**Link**
- https://www.acmicpc.net/problem/12919
