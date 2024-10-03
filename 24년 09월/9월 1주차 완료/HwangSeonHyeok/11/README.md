# [백준 - g5] 2467. 용액

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 이분 탐색
- 투 포인터

## :round_pushpin: **Logic**

오름차순으로 정렬하고 현제 선택한 용액의 음수보다 크지않은 가장 큰 수의 위치를 이분탐색으로 찾는다.  
그 후 찾은 용액과 그 다음 인덱스의 용액을 각각 지금 선택한 용액과 섞어서 혼합한 용액의 특성값이 0에 더 가까운 것을 계산한다.  
이를 반복해서 특성값이 0에 가장 가까운 조합을 기록.

```java
		for (int i = 0; i < n - 1; i++) {
			int tmp = -arr[i];
			int left = i + 1;
			int right = n - 1;
			int mid = 0;
			while (left < right) {
				mid = (left + right) / 2 + 1;
				if (arr[mid] > tmp) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
			mid = (left + right) / 2;
			int compdiff;
			if (mid == n - 1) {
				compdiff = Math.abs(arr[mid] - tmp);
			} else {
				int absMid = Math.abs(arr[mid] - tmp);
				int absMidPlus = Math.abs(arr[mid + 1] - tmp);
				if (absMid > absMidPlus) {
					compdiff = absMidPlus;
					mid = mid + 1;
				} else {
					compdiff = absMid;
				}
			}
			if (diff > compdiff) {
				diff = compdiff;
				idx1 = i;
				idx2 = mid;
			}
		}
```

## :black_nib: **Review**

처음에 mid+1값이 답인경우도 인덱스를 그냥 mid로 기록해서 틀렸었다..

## 📡**Link**

https://www.acmicpc.net/problem/2467
