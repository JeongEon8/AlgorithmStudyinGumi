# [PGS - LV2] 84512. 모음사전


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디
- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
첫 글자가 AEIOU순으로 바뀔때마다 781개씩의 차이가 있다.  
이를 이용해 AEIOU중 몇번째 모음인지를 확인하여 구한다.  
마찬 가지로 두번째는 (781-1)/5개씩의 차이가 있고 이런식으로 문자열 끝까지 반복한다.
```java
 String vowel = "AEIOU";
public int solution(String word) {
	int answer = 0;
	String vowel = "AEIOU";
	int total = 781;
	for(int i = 0; i<word.length();i++){
		int vowelToNum = vowel.indexOf(word.charAt(i));
		answer+= vowelToNum*total+1;
		total--;
		total/=5;
	}
	return answer;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/84512