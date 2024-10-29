# [백준] 4673. 셀프 넘버 
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
		int sum = num;
		while (num != 0) {
			sum += num % 10; //각 자리수 더함 
			num = num / 10; //다음 자리수로 이동함 
		}
```

```java
			if (a <= 10000) { //결과가 10000 이하일 시 
				arr[a - 1] = 1; //생성자 있으면 1로 지정 
			}
```

의 과정을 거쳐 생성자 없는 수만 출력한다. 


## :black_nib: **Review**
- 간단하지만, 내게는 로직이 바로 떠오르지 않는 문제였다. 

## 📡**Link**
- https://www.acmicpc.net/problem/4673 
