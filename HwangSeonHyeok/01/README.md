# [PGS - LV2] 17680. [1차] 캐시

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
캐시에 있는 경우 삭제하고 뒤에 새로 추가하면서 1가중치를 준다(캐시가 있는경우).  
캐시에 없는 경우 캐시가 넘치는 경우 가장 앞 캐시를 지우고 추가한다.
캐시 사이즈가 0인 경우는 모든 도시에 대해 5의 가중치를 준다.
```java
if(cacheSize==0) return cities.length * 5;
int answer = 0;
List<String> list = new ArrayList<>();
for(String city: cities){
	city = city.toLowerCase();
	if(list.remove(city)){
		answer += 1;
	}else{
		if(list.size() >= cacheSize){
			list.remove(0);
		}
		answer += 5;
	}
	list.add(city);
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=java