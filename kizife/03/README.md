# [백준] 1181. 단어 정렬 
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
문자열, 정렬 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
입력순으로 단어를 저장한다... set에 (중복 제거 목적)

리스트화하고, Collections.sort로 정렬한다...
```java
		 Collections.sort(list, (a, b) -> {
	            if (a.length() != b.length()) {
	                return a.length() - b.length();  // 길이 비교
	            }
	            return a.compareTo(b);  // 알파벳 비교
	        });
``` 


## :black_nib: **Review**
- 양심 없는 문제 선정! 죄송합니다 월요일 5시 넘어서 풀기 시작했습니다. 그렇지만 set을 써 본 경험이 한 번(아마도)뿐이니 이 정도는 연습했다 쳐도 되지 않을까요? 

## 📡**Link**
- https://www.acmicpc.net/problem/1181 
