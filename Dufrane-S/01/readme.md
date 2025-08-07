  # [백준 - 실버 5]1676. 팩토리얼 0의 갯수
  
  ## ⏰**time**
  30분
  
  ## :pushpin: **Algorithm**
  수학
  
  ## ⏲️**Time Complexity**
  $O(N)$ 
  
  ## :round_pushpin: **Logic**
  1. 끝자리에 0이 가려면 10이 곱해져야한다
  2. 10=2*5이고 2는 2,4,6,8과 같이 많지만 5는 5,10,15와 같이 적다
  3. 5의 갯수를 세어준다
  ```
    while(i>=5){
      answer+=i/5;
      i/=5;
    }
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/1676
