# [백준 - 실버 5] 1380. 귀걸이
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 2번 들어오면 귀걸이는 가져갔다는 것이다.
2. 처음 들어오면 true, 안들어오면 false, 두번 들어오면 false이다.
3. true인 경우만 출력하면 된다.
   ```cpp
		bool arr[101] = { 0 };
		for (int i = 0; i < (2 * n) - 1; i++) {
			int num;
			char flag;
			cin >> num >> flag;
			if (arr[num]) {
				arr[num] = false;
			}
			else {
				arr[num] = true;
			}
		}
   ```

## :black_nib: **Review**
- 와 진짜, 공백 문자 받으려고 시간 다 쓰고...
- 출력 형식 안 지켜서 또 틀리고.. ㅠㅠ

## 📡 Link
https://www.acmicpc.net/problem/1380
