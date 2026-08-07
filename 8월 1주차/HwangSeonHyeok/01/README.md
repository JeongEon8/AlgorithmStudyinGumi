# [PGS - LV2] 12951. 영어 끝말잇기

## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 문자열

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
각 char단위로 첫글자일때만 판단하고 대문자 나머진 소문자로 바꿔넣는다.
```java
boolean isFirst = true;
for(char c : s.toCharArray()){
	if(c==' '){
		answer += c;
		isFirst = true;
	}else{
		if(isFirst){
			isFirst = false;
			answer+= Character.toUpperCase(c);
		}else{
			answer+= Character.toLowerCase(c);
		}
	}
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12951