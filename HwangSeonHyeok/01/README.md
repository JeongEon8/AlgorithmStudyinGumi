# [PGS - LV2] 70129. 이진 변환 반복하기

## ⏰ **time**

	10분

## :pushpin: **Algorithm**
- 구현
- 문자열

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
0을 모두 제거하고 이전과 길이차이로 제거한 0개수를 더해준다. 이후 toBinaryString으로 길이를 이진법으로 변환하는 과정을 반복한다.
```java
while(s.length()!=1){
	int prevLength = s.length();
	String one = s.replace("0","");
	int oneCnt = one.length();
	s = Integer.toBinaryString(oneCnt);
	answer[1] += prevLength- oneCnt;
	answer[0]++;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/70129