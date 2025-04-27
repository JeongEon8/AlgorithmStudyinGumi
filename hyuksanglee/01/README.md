# [백준 - S5] 1427. 소트인사이드

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
배열로 받고 sort로 정렬해서 반대로 출력하면 끝!!
```java
String[] input  = in.readLine().split("");
		Arrays.sort(input);
	
		for(int i =0; i<input.length;i++) {
			System.out.print(input[input.length-i-1]);
		}
```


## :black_nib: **Review**  
너무 쉽네요
## 📡**Link**

https://www.acmicpc.net/problem/1427
