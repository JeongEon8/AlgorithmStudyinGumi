# [백준 - 골드 5] 1759.암호 만들기

## ⏰ **time**
40분

## :pushpin: **Algorithm**
백트레킹

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 정렬해서 알파벳을 입력받는다.
2. 하나씩 string에 넣어서 길이가 C가 되면 자음이 2개 이상, 모음이 1개 이상인지 확인해서 출력한다.
```cpp

bool isThereMoJa(string str) {
	int mo = 0;
	int ja = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
			mo++;
		}
		else {
			ja++;
		}
	}

	if (mo >= 1 && ja >= 2) {
		return true;
	}

	return false;
}

void backtracking(string str, int start) {
	if (str.length() == L) {
		if (isThereMoJa(str)) {
			cout << str << '\n';
		}
		return;
	}

	for (int i = start; i < C; i++) {
		str.push_back(v[i]);
		backtracking(str, i + 1);
		str.pop_back();
	}

}
```

## :black_nib: **Review**
- 조건은 끝까지 보자! 모음만 적으면 틀리는 거임~

## 📡 Link
[https://www.acmicpc.net/problem/1759](https://www.acmicpc.net/problem/1759)
