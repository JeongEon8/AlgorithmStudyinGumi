# [SWEA - D4] 3752. 가능한 시험 점수
 
## ⏰  **time**
40분
  
## :pushpin: **Algorithm**
dp
  
## ⏲️**Time Complexity**
$O(N * 2^N)$
    
## :round_pushpin: **Logic**
- 기존 set을 clone하여, clone된 set을 돌며 시험문제의 i번째 배점을 더한 값을 기존 set에 추가
- clone되어 새로 생긴 set은 더한 버전으로 추가되는 형식

## :black_nib: **Review**
- hashset에는 clone이 있는데 set에는 왜 clone이 없는가...
- dp 싫어.............
- 엄청 커서 초과날 줄 알았는데 이게 되네...
  
## 📡 Link
[https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV14nnAaAFACFAYD&categoryId=AV14nnAaAFACFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2)
