# [PGS - LV2] 12980. 점프와 순간 이동


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**

$O(logn)$

## :round_pushpin: **Logic**
n에서부터 짝수면 반을 줄이고(순간이동) 홀수면 순간이동할 수 없으므로 점프하면서 건전지를 사용한다.
```java
while(n>0){
	if(n%2==0)n/=2;
	else{
		n--;
		ans++;
	}
}
```

## :black_nib: **Review** 
조건 안보고 바텀업 dp로 풀었다가 틀렸었다..
## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12980