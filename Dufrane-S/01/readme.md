  # [백준 - 실버 5] 1543. 문서검색
  
  ## ⏰**time**
  20분
  
  ## :pushpin: **Algorithm**
  그리디
  
  ## ⏲️**Time Complexity**
  $O(N)$
  
  ## :round_pushpin: **Logic**
  1. 중복되는 것은 빼야하기 때문에 검색된 내용을 잘라내고 재검색하며 갯수 확인
  ```java
      while(s.indexOf(keyword)!=-1){
      s = s.substring(s.indexOf(keyword)+keyword.length());
      answer++;
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/1543
