  # [백준 - 실버 4] 4949. 균형잡힌 세상
  
  ## ⏰**time**
  30분
  
  ## :pushpin: **Algorithm**
  스택
  
  ## ⏲️**Time Complexity**
  $O(N)$
  
  ## :round_pushpin: **Logic**
  1. 여는 괄호는 스택에 쌓고
  2. 닫는 괄호는 스택의 여는 괄호를 확인 후 제거
  ```
    for(int i=0;i<s.length();i++){
	            char now =s.charAt(i);
	            if(now=='['||now=='('){
	                dq.addLast(now);
	            }else if(now==']'){
	                if(dq.isEmpty()){
	                    yes=false;
	                    break;
	                }
	                char last = dq.pollLast();
	                if(last!='['){
	                    yes=false;
	                    break;
	                }
	            }else if(now==')'){
	                if(dq.isEmpty()){
	                    yes=false;
	                    break;
	                }
	                char last = dq.pollLast();
	                if(last!='('){
	                    yes=false;
	                    break;
	                }
	            }
	        }
  ```
  
  ## :black_nib: **Review**
  - 여는 괄호가 남아도 no
  
  ## 📡 Link
  https://www.acmicpc.net/problem/4949
