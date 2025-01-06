# [백준 - S5] 1181. 단어 정렬

## ⏰ **time**

# 30분

## :pushpin: **Algorithm**

- 브루트포스

## ⏲️**Time Complexity**

$O(Nlog(N))$

## :round_pushpin: **Logic**

Comparator로 정렬 규칙을 만들어 주고 정렬해준다.

```java
	for(int i=0;i<51;i++) {
			if(list[i].size()==0) {
				continue;
			}else if(list[i].size()==1) {
				System.out.println(list[i].get(0));
			}else {
				Collections.sort(list[i]);
				for(int j=0;j<list[i].size();j++) {
					System.out.println(list[i].get(j));
				}
			}
		}
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/1181
