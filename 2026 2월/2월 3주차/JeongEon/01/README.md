# [백준 - 실버 5] 1543.문서 검색

## ⏰ **time**
5분

## :pushpin: **Algorithm**
브루트포스, 문자열

## ⏲️ **Time Complexity**
$O(N^M)$

## :round_pushpin: **Logic**
1. input 문자열을 돌면서 searchKeyword의 첫 문자와 동일한 것이 나오면, searchKeyword와 같은지 판단한다.
2. 전부 같다면 `cnt + 1`하고 `i + (searchKey 단어 길이)`한다.
```cpp
bool check(int i) {
	for (int j = 0; j < searchKeyword.length(); j++) {
		if (searchKeyword[j] != input[i + j]) {
			return false;
		}
	}
	return true;
}

void search() {
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == searchKeyword[0]) {
			if (check(i)) {
				cnt++;
				i += searchKeyword.length() - 1;
			}
		}
	}
}	
```

## :black_nib: **Review**
- [Wii Shop Channel Theme HQ | Wii music (1 HOUR)](https://www.youtube.com/watch?v=vIbK3GUr6uI)
- 오늘은 다른 노래를 들어봤어요! Wii에 Shop 노래 경쾌하고 좋아용
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/1543](https://www.acmicpc.net/problem/1543)
