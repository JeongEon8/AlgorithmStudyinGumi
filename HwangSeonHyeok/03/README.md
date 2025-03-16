# [백준 - S4] 20937. 떡국

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 애드 혹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
같은 크기의 그릇이 있으면 겹쳐놓을 수 없으니 무조건 다른 탑이 생긴다.  
같은 크기가 아닌 세트는 무조건 하나의 탑을 쌓을 수 있으므로 각각의 같은 크기인 그릇의 크게를 세고 가장 많은 같은 크기의 갯수를 출력하면된다.
```java
int[] arr = new int[50001];
for (int i = 0; i < n; i++) {
	arr[Integer.parseInt(split[i])]++;
}
int max = 0;
for (int i = 1; i <= 50000; i++) {
	max = Math.max(max, arr[i]);
}
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/20937
