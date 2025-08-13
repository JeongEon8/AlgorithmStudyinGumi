  # [백준 - 실버 5] 10815. 숫자카드
  
  ## ⏰**time**
  10분
  
  ## :pushpin: **Algorithm**
  자료구조
  
  ## ⏲️**Time Complexity**
  $O(N)$ 
  
  ## :round_pushpin: **Logic**
  1. 맵으로  O(N)에 체크
  ```
    for(int i=0;i<M;i++){
		    if(null!=map.get(Integer.parseInt(st.nextToken()))){
		        System.out.print("1 ");
		    }else{
		        System.out.print("0 ");
		    }
		}  
  ```
  
  ## :black_nib: **Review**
  - 이진탐색으로도 가능
  
  ## 📡 Link
  https://www.acmicpc.net/problem/10815
