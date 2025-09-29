
# [백준- S4] 1015. 수열 정렬

## ⏰  **time**
40분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**

- 배열을 오름차순으로 정렬
- 정렬된 배열에서 원래 인덱스를 이용해 P배열을 정렬 후 위치를 기록
```java
for (int i = 0; i < n; i++) {
	A[i] = sc.nextInt();
	arr[i][0] = A[i];
	arr[i][1] = i;
}

Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

int[] P = new int[n];
for (int i = 0; i < n; i++) {
	P[arr[i][1]] = i; 
}
```


## :black_nib: **Review**
- 시간이 없다..


## 📡**Link**
- https://www.acmicpc.net/problem/1015

