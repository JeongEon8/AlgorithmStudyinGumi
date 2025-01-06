# [백준 - 실버 4] 11652. 카드
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
map

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. map을 통해 중복 수 추가 불가능!
   ```cpp
	for (auto x : m) {
		if (x.second > maxi) {
			maxi = x.second;
			result = x.first;
		}
	}
   ```

## :black_nib: **Review**
- 입력 크기를 잘 보자... input 크기가 integer가 아니야!!

## 📡 Link
https://www.acmicpc.net/problem/11652
