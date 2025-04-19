# [백준 - S4] 25179. 배스킨라빈스~N~귀엽고~깜찍하게~

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 게임 이론

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**  
상대가 어떤 수를 부르든 m+1을 만드는 식의 전략이 필승법이다.  
이 때 상대가 준서가 부를 수 있는 숫자가 n한개 밖에 없는경우만 패배하므로 (n % (m + 1)) == 1인 경우만 패배한다.
```java
long n = Long.parseLong(split[0]);
long m = Long.parseLong(split[1]);
if ((n % (m + 1)) == 1) {
	System.out.println("Can't win");
} else {
	System.out.println("Can win");
}
```

## :black_nib: **Review**
유명한 게임

## 📡**Link**
https://www.acmicpc.net/problem/25179
