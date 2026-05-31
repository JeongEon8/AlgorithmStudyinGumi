# [PGS - LV2] 12939. 최댓값과 최솟값


## ⏰ **time**

5분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
StringTokenizer로 파싱하여 최댓값과 최솟값을 찾는다.
```java
StringTokenizer st = new StringTokenizer(s);
int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
while(st.hasMoreTokens()){
	int current = Integer.parseInt(st.nextToken());
	max = Math.max(max,current);
	min = Math.min(min,current);
}
answer+= min+" "+max;
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12939