# [백준 - 실버3] 9461. 파도반 수열
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
피보나치 수열, DP

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 피보나치 수열 arr[n] = arr[i - 2] + arr[i - 3];
   ```cpp
void pado() {
	for (int i = 3; i < N; i++) {
		long long int temp = arr[i - 2] + arr[i - 3];
		arr.push_back(temp);
	}
}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/9461
