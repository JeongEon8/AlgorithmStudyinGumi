# [백준 - 실버4] 26069. 붙임성 좋은 총총이
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
Set

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. set에 "ChongChong"을 넣어두고, set에 이름이 있는 사람이 등장하면 모두 insert한다.
```cpp
	for (int i = 0; i < N; i++) {
		string A, B;
		cin >> A >> B;
		
		if (name.find(A) != name.end() || name.find(B) != name.end()) {
			name.insert(A);
			name.insert(B);
		}
	}
```

## :black_nib: **Review**
- 총총이 귀엽다
  ![image](https://github.com/user-attachments/assets/64c08aef-dbbb-4ae2-a7df-e8ee49150e8a) ![image](https://github.com/user-attachments/assets/16cd7154-c99e-485e-be8f-46982c5b5d47)



## 📡 Link
https://www.acmicpc.net/problem/26069
