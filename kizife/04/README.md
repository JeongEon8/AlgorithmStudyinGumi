# [백준] 1427. 소트인사이드
 
## ⏰  **time**
30분 

## :pushpin: **Algorithm**
문자열, 정렬 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1. 일단 문자열을 입력받는다.
```java
String input = sc.nextLine();
```

2. 문자열을 문자 배열로 변환하고, 각 문자를 숫자로 변환 -> 리스트에 추가
```java
        for (char c : input.toCharArray()) {
            list.add(c - '0'); //숫자로 변환
        }
```

3. 리스트를 내림차순 정렬하기
```java
Collections.sort(list, Collections.reverseOrder());
```


## :black_nib: **Review**
- 날먹하려고 푼 게 아니라..........놀랍게도 공백 없는 숫자(혹은 문자) 입력이 습관화가 안 돼서...ㅠ 

## 📡**Link**
- https://www.acmicpc.net/problem/1427 
