# [백준 - 실버4] 20363. 당근 키우기
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(1)$

## :round_pushpin: **Logic**
1. 물이나 햇빛 중 큰것을 먼저 더한다.
2. 작은 것을 10으로 나눈 몫을 더하고 다시 작은 것을 더한다.
   ```cpp
		if (sun > water) {
		result = sun + water / 10 + water;
	}
	else {
		result = water + sun / 10 + sun;
	}
   ```

## :black_nib: **Review**
- 꽉꽉꽉꽉!! 🥕🥕

## 📡 Link
https://www.acmicpc.net/problem/20363
