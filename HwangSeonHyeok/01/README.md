# [PGS - LV2] 12981. 영어 끝말잇기

## ⏰ **time**

	10분

## :pushpin: **Algorithm**
- 셋
- 구현

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
나왔던 단어들을 set에 기록하면서 만약 끝말잇기에 안 맞거나 중복된 단어가 나오면 그때의 차례를 계산해서 답을낸다.
```java
Set<String> set = new HashSet<>();
set.add(words[0]);
for(int i = 1; i<words.length;i++){
	String prev = words[i-1];
	String current = words[i];
	if((prev.charAt(prev.length()-1)!=current.charAt(0))||set.contains(current)){
		answer[0] = i%n+1;
		answer[1] = i/n+1;
		return answer;
	}
	set.add(current);
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12981