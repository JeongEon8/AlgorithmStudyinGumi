# [PGS - Lv2] 02_JadenCase 문자열 만들기

## ⏰**time**

- 10분

## :pushpin: **Algorithm**

- 문자열

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. charAt 을 써서 하나씩 비교하면서 빈값이면 다음에 오는 문자가 소문자 일경우 대문자로 변경하고 나머지는 대문자 일경우 소문자로 변경
   ```
  for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(type==1&&  c !=' '){
                type = 0;
                if(c>='a'&& c<='z'){
                    c+='A'-'a';
                }
                
            }
            else {
                if(c == ' '){
                    type =1;
                } else{ 
                     if(c>='A'&& c<='Z'){
                    c+='a'-'A';
                }
                }
            }
            answer+=c;
        }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12951
