# [백준 - S5] 10814. 나이순 정렬

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

Comparator를 만들어서 정렬

```java
	list.sort(new Comparator<Mem>() {
			@Override
			public int compare(Mem o1, Mem o2) {
				if(o1.age!=o2.age) {
					return Integer.compare(o1.age, o2.age);
				}else {
					return Integer.compare(o1.id, o2.id);
				}
			}
		});
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/10814
