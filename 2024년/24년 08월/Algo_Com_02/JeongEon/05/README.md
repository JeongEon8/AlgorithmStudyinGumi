# [백준 - 실버4] 11656. 접미사 배열
 
## ⏰  **time**
12분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력한 문자열을 reverse을 통해 뒤집고 pop_back을 통해 하나씩 빼고 넣는다.
2. 해당 값을 reverse한다.
3. sort정렬하면 알파벳 오름차순으로 정렬해준다.
```cpp
	reverse(input.begin(), input.end());
	for (int i = 0; i < size; i++) {
		result.push_back(input);
		input.pop_back();
		reverse(result[i].begin(), result[i].end());
	}

	sort(result.begin(), result.end());
```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/11656
