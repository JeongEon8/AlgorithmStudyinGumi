# [백준 - P5] 1306. 달려라 홍준

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 자료 구조
- 세그먼트 트리
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

범위에서의 최대값을 저장하는 세그먼트 트리를 만든다.

```java
	static int[] arr;
	static int[] segTree;

	static int makeSeg(int index, int s, int e) {
		if (s == e) {
			segTree[index] = arr[s];
			return segTree[index];
		}
		int mid = (s + e) / 2;
		int left = makeSeg(index * 2, s, mid);
		int right = makeSeg(index * 2 + 1, mid + 1, e);
		segTree[index] = Math.max(left, right);
		return segTree[index];
	}

	static int querySeg(int index, int s, int e, int ts, int te) {
		if (ts <= s && e <= te) {
			return segTree[index];
		}
		if (s > te || e < ts) {
			return 0;
		}
		int mid = (s + e) / 2;
		int left = querySeg(index * 2, s, mid, ts, te);
		int right = querySeg(index * 2 + 1, mid + 1, e, ts, te);
		return Math.max(left, right);
	}
```
범위를 지나가면서 세그먼트 트리의 구간에서의 최대값을 찾는다.
```java
	int end = n - m + 1;
	StringBuffer sb = new StringBuffer();
	for (int i = m; i <= end; i++) {
		sb.append(querySeg(1, 1, n, i - m + 1, i + m - 1) + " ");
	}
```

## :black_nib: **Review**
특강에서 세그먼트 트리를 배우고 복습겸 풀어보았다.  
알고리즘 유형을 알고 세그먼트 트리를 배운 코드를 참고해서 작성해 어렵지 않게풀었다.
그냥 출력하는 방식에서 StringBuffer로 바꿨더니 시간이 1/4로 줄었다..  
달려라 홍준!

## 📡**Link**

https://www.acmicpc.net/problem/1306
