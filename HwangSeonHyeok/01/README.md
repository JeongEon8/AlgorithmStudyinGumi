# [백준 - S4] 19939. 박 터뜨리기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
k개의 바구니에 우선 1~k의 박을 담는다.  
남은 박들이 k개의 배수이면 모두 고르게 더 담아줘서 공의 차는 k-1개, k로 나누어 떨어지지 않으면 많은 양을 담은 바구니부터 담아야 하므로 k개의 차이가 난다.  
```java
int minimum = k * (k + 1) / 2;
if (n >= minimum) {
	if ((n - minimum) % k == 0) {
		System.out.println(k - 1);
	} else {
		System.out.println(k);
	}
} else {
	System.out.println(-1);
}
```


## :black_nib: **Review**  
수학 문제  
## 📡**Link**
https://www.acmicpc.net/problem/19939
