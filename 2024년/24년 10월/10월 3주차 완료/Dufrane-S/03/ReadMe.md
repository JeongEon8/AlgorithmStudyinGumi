# [백준 - S4] 2839. 설탕 배달

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
숫자별로 -3, -5를 해서 기록된 숫자를 확인 후 +1 해서 작은 값을 대입

```java
	for(int i=3;i<n;i++) {
			if(list[i-3]!=999999 && list[i-3]+1<list[i]) {
				list[i]=list[i-3]+1;
			}
			if(i-5>=0&&list[i-5]!=999999 && list[i-5]+1<list[i]) {
				list[i]=list[i-5]+1;
			}
		}
```

## :black_nib: **Review**


## 📡**Link**

