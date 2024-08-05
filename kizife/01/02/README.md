# [백준] 10699. 오늘 날짜
 
## ⏰  **time**
10분 미만

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. LocalDate 클래스 임포트
import java.time.LocalDate;

2. 현재 날짜를 가져와서 seoulDate라는 변수에 저장
LocalDate seoulDate = LocalDate.now();

3. 현재 날짜 출력
System.out.println(seoulDate);
   

## :black_nib: **Review**
- 로컬 날짜 가져오는 법을 몰라서 검색하고 외웠다.
- 검색하다 마주한 '타임존'이라는 표현에 어리둥절함... 그렇게 어렵게 생각할 필요가 없었다.
