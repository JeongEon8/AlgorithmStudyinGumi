# [PGS - LV2] 77885. 2개 이하로 다른 비트

## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
짝수인 경우 마지막 자리수가 0이므로 1만 올리면 무조건 1자리를 바꿀 수 있다.
홀수의 경우 가장 마지막 01 부분을 키워서 10으로 바꾸면 가장 비트가 다른 가장 작은 수이다.
```java
for(int i= 0; i<numbers.length; i++){
	long current = numbers[i];
	if(current%2==0){
		answer[i] = current+1;
	}else{
		String binary = "0"+Long.toBinaryString(current);
		int lastZero = binary.lastIndexOf("0");
		String ans = binary.substring(0,lastZero)+"10"+binary.substring(lastZero+2);
		answer[i] = Long.parseLong(ans,2);
	}
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/154538