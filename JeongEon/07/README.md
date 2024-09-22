# [백준 - 실버5] 4659. 비밀번호 발음하기
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 모음이 한번 이상 입력되었는가?
2. 모음이나 자음이 3번이상 연속되는가?
3. 같은 단어가 2번이상 반복되는가? (ee, oo는 허용)
   ```cpp
		for (int i = 0; i < s.length(); ++i) {
			con = false;
			if (i != 0) {	// 3번 조건
				if (s[i] == s[i - 1] && s[i] != 'e' && s[i] != 'o') {
					flag = true;
					break;
				}
			}

			for (int j = 0; j < 5; ++j) {
				if (s[i] == v[j]) {
					if (check == false) {
						count = 0;
					}
					m = true;
					check = true;
					con = true;
					++count;
				}
			}

			if (!con) {
				if (check == true) {
					count = 0;
				}
				check = false;
				++count;
			}

			if (count == 3) {	// 2번 조건
				flag = true;
				break;
			}

			if (flag) {
				break;
			}
		}
   ```

## :black_nib: **Review**
- 정말 귀찮은 문제였다! 이런 문제 싫어요

## 📡 Link
https://www.acmicpc.net/problem/4659
