# [백준 - S3] 1003. 피보나치 함수

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- Dp

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
- 0,1,2, 일때 미리 설정후 3부터 n-1, n-2일때의 0과 1 횟수를 더해준다.
```java
public static void test(int n) {
		arr[n][0]+= arr[n-1][0]+arr[n-2][0];
		arr[n][1]+= arr[n-1][1]+arr[n-2][1];
	}
```


## :black_nib: **Review**  
오랜만에 쉬웠어요
## 📡**Link**

https://www.acmicpc.net/problem/1003
