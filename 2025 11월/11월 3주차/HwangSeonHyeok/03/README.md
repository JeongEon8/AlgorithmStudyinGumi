# [백준 - S5] 25707. 팔찌 만들기

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 정렬
- 애드 혹


## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
차이가 최소가 되려면 크기가 다른 순서대로 차를 더한게 최소이므로 정렬을하고 순서대로 차를 답에 더한다.  
원형 팔찌이므로 가장 큰 수 와 가장 작은 수의 연결까지 계산한다.
```java
Arrays.sort(arr);
int ans = 0;
for (int i = 0; i < n - 1; i++) {
    ans += arr[i + 1] - arr[i];
}
ans += arr[n - 1] - arr[0];
```  


## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/25707