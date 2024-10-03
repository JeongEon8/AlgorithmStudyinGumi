# [백준 - 실버5] 14405. 피카츄
 
## ⏰  **time**
5분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력한 문자열을 2개, 3개씩 짤라 pi인지 ka인지 chu인지 확인한다.
2. 없으면 NO
```cpp
	bool yes = true;
	for (int i = 0; i < input.length(); i++) {
		if (i < input.length() - 1 && input.substr(i, 2) == "pi" || input.substr(i, 2) == "ka") {
			i += 1;
		}
		else if ((i <( input.length() - 2)) && (input.substr(i, 3) == "chu")){
			i += 2;
		}
		else {
			yes = false;
			break;
		}
	}
```

## :black_nib: **Review**
- 피카츄~

## 📡 Link
https://www.acmicpc.net/problem/14405
