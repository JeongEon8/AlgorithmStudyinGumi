# [백준 - 실버3] 17413. 단어 뒤집기 2
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
string

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 단어 뒤집기는 reverse STL 함수를 활용한다.
2. 만약 <가 나오면 temp가 ""이 아니면 temp를 reverse해서 붙이고, >가 나올때까지 또 더한다.
3. 띄어쓰기면 어때까지 temp에 모은걸 리버스해서 더한다.
   ```cpp
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '<') {
			if (temp != "") {
				reverse(temp.begin(), temp.end());
				result += temp;
				temp = "";
			}
			for (; input[i] != '>'; i++) {
				result += input[i];
			}
			result += input[i];
		}
		else if (input[i] == ' ') {
			reverse(temp.begin(), temp.end());
			result += temp + " ";
			temp = "";
		}
		else {
			temp += input[i];
		}
	}
   ```

## :black_nib: **Review**
- 단어를 뒤집어!!! 뒤집어~~~ 🍳

## 📡 Link
https://www.acmicpc.net/problem/17413
