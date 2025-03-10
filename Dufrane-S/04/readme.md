# [백준 - S5] 25757. 임스와 함께하는 미니게임

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 중복을 map으로 확인하고 게임 가능인원을 파악
2. 게임 횟수 구하기

```java
Map<String,Integer>map = new HashMap<>();
		int count =0;
		for(int i=0;i<n;i++){
		    String now = br.readLine();
		    if(map.get(now)==null){
		        map.put(now,1);
		        count++;
		    }
		}
		int p=0;
		if(m=='Y'){
		    p=1;
		}else if(m=='F'){
		    p=2;
		}else if(m=='O'){
		    p=3;
		}
		int answer = count/p;
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25757
