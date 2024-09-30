# [백준 - 실버5] 25757. 임스와 함께하는 미니게임
 
## ⏰  **time**
7분

## :pushpin: **Algorithm**
맵

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 게임에 대한 정보를 map에 입력해놓는다.
2. set에 유저 이름을 입력받아 넣고, 중복을 제거한다.
3. 해당 게임에 필요한 유저 수로 나눈다.
   ```cpp
	for (int i = 0; i < N; i++) {
		cin >> input;
		player.insert(input);
	}

	cout << player.size()/num[game] << endl;
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/25757
