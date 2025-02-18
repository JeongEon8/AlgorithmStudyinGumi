# [백준 - 실버3] 10972. 다음 순열
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
수

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 뒤에서 부터 수차적으로 검사를 하면서 값이 크면 변경하고 갱신
2. 없을경우 -1 출력
   
```java
    while (idx > 0 && num[idx - 1] > num[idx]) {
					idx--;
				}

				if (idx == 0) {
					System.out.println(-1);
					return;
				}

				
				int big_idx = N - 1;
				while (big_idx > idx && num[idx - 1] > num[big_idx]) {
					big_idx--;
				}

			
				int temp = num[idx - 1];
				num[idx - 1] = num[big_idx];
				num[big_idx] = temp;
```

## :black_nib: **Review**
- 실버도 어려워

## 📡 Link
https://www.acmicpc.net/problem/10972
