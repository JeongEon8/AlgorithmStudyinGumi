# [백준 - 실버 3] 1431. 시리얼 번호

## ⏰  **time**
30분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 사이즈가 작은 거 먼저!
2. 숫자가 있는 거 더해서 작은 순으로!
3. 알파벳 순으로!
```cpp
bool cmp(string a, string b) {
	int asize = a.length();
	int bsize = b.length();
	int asum = 0;
	int bsum = 0;

	if (asize != bsize) {
		return asize < bsize;
	}

	for (int i = 0; i < a.size(); i++) {
		if (a[i] >= '0' && a[i] <= '9') {
			asum += int(a[i]) - '0';
		}

		if (b[i] >= '0' && b[i] <= '9') {
			bsum += int(b[i]) - '0';
		}
	}

	if (asum != bsum) {
		return asum < bsum;
	}

	return a < b;
}
```

## :black_nib: **Review**
- 문제 풀면서 대탈출2 보고 있는데 와 진짜 너무 재밌다!
- 방탈출 원트해요ㅠ
  
## 📡 Link
https://www.acmicpc.net/problem/1431
