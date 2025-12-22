# [백준 - S3] 28353. 고양이 카페

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬
- 두 포인터

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
무게를 정렬해두고 가장 무게가 조금 나오는 고양이와무릎위에 앉힐 수 있는 최대 무게의 고양이와 매칭하여 카운팅하면된다.
```java
Arrays.sort(cats);
int left = 0;
int right = n - 1;
int ans = 0;
while (left < right) {
	if (cats[left] + cats[right] <= k) {
		ans++;
		left++;
		right--;
	} else {
		right--;
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/17124
