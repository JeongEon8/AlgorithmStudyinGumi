# [백준 - 실버3] 20291. 파일 정리
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
맵

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. . 뒤에 나오는 확장자는 substr을 통해 저장한다.
2. map에 일단 insert한 후 value를 1 증가 시킨다.
3. insert할 때, 중복의 경우는 insert되지 않는다. 고로, 우리가 중복을 따로 확인할 필요없다.
   ```cpp
	map<string, int> file;
	for (int i = 0; i < N; i++) {
		string input;
		cin >> input;
		
		string name = "";
		for (int j = 0; j < input.length(); j++) {
			if (input[j] == '.') {
				name = input.substr(j + 1);
				break;
			}
		}

		file.insert({ name, 0 });
		file[name]++;
	}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/20291
