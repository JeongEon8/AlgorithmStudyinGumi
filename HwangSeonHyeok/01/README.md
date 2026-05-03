# [PGS - LV2] 131127. 할인행사


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 투 포인터
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
항상 10일씩의 품목만 기록한다.  
하루가 지나면 지난날 할인 품목수를 빼고 새로 들어온 품목을 넣고 목표와 일치하는지 비교한다.
```java
Map<String,Integer> mapper = new HashMap<>();
for(int i = 0; i<want.length; i++){
	mapper.put(want[i],i);
}
for(int i = 0; i<10; i++){
	if(mapper.containsKey(discount[i]))
		arr[mapper.get(discount[i])]++;
}
if(isCorrect(number, arr)) ans++;
for(int i = 1; i<discount.length-9; i++){
	if(mapper.containsKey(discount[i-1]))
		arr[mapper.get(discount[i-1])]--;
	if(mapper.containsKey(discount[i+9]))
		arr[mapper.get(discount[i+9])]++;
	if(isCorrect(number,arr)){
		ans++;
	}
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/131127