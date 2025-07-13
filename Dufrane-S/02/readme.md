# [백준 - S4] 17266. 어두운 굴다리

## ⏰  **time**
40분

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(log N)

## :round_pushpin: **Logic**
1. 이분탐색으로 높이를 정해주고
2. 빛의 끝부분과 다음 위치가 연결되어있는지 체크
```
	static boolean check(int mid, int [] arr, int n) {
		int now = 0;
		for(int i : arr) {
			if(i-mid>now)return false;
			now = i+mid;
		}
		if(now>=n)return true;
		return false;
	}
```

## :black_nib: **Review**
배열로 직접 빛을 시뮬레이션하면 시간초과
## 📡 Link
https://www.acmicpc.net/problem/17266
