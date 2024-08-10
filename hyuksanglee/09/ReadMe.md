# [SWEA - 모의 SW 역량테스트] 5650. 핀볼 게임
 
## ⏰  **time**
5시간

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력 받은 배열 2차원 배열에 담기
   - 웜홈이 있을경우 웜홈배열에 넣어준다
3. 블록 들어오는 방향에 따라 설정
	- 붙이는 면이 직각이면 180도 회전시켜주고 아닐경우 해당방향으로 회전시켜준다
4. 웜홈을 만났을경우
   	- 웜홈 배열에서 위치를 찾아 좌표를 바꿔어준다
5. 이중 for문을 돌면서 해당판이 0인칸을 찾아 시뮬레이션 돌려준다.

  

## :black_nib: **Review**
- bufferedReader를 써서 돌렸을때는 오류가 뜨길래 다른방법으로 시도했지만
- 알고보니 scanner만 바꾸면 해결되는거였어요

  
## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo&categoryId=AWXRF8s6ezEDFAUo&categoryType=CODE&problemTitle=%EB%AA%A8%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1


  
