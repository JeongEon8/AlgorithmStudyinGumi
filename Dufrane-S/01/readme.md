  # [백준 - 실버 5] 2941. 크로아티아 알파벳
  
  ## ⏰**time**
  30분
  
  ## :pushpin: **Algorithm**
  구현, 문자열
  
  ## ⏲️**Time Complexity**
  $O(N^2)$
  
  ## :round_pushpin: **Logic**
  1. 크로아티아 알파벳을 찾고
  2. 둘로 나누어서 다시 알파벳을 찾고
  3. 알파벳이 없으면 글자 길이만큼 숫자 ++
  ```
    static void split(String s){
	    for(String goal : two){
	        if(s.indexOf(goal)!=-1){
	            int point = s.indexOf(goal);
	            String a = s.substring(0,point);
	            String b = s.substring(point+goal.length(),s.length());
	            answer+=1;
	            split(a);
	            split(b);
	            return;
	        }
	    }
	    answer+=s.length();
	}
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/2941
