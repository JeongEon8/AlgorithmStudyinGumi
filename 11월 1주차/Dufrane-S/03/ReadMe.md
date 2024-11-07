# [BOJ - S2] 30804. 과일탕후루
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. 모든 탕후루 조합의 길이를 파악해서 큰 것을 반환
```
for (int i = 1; i < 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				int temp = 0;
				for (int k = 0; k < n; k++) {
					if (list[k] == i || list[k] == j) {
						temp++;
					} else {
						if (large < temp) {
							large = temp;
						}
						temp = 0;
					}
				}
				if (large < temp)
					large = temp;
			}
		}
```
## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/30804
