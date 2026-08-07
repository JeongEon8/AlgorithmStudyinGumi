# [PGS - Lv2] 01_올바른 괄호

## ⏰**time**

- 12분

## :pushpin: **Algorithm**

- 스텍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. '(' , ')' 두가지에 따라 조건을 설정 해준다.
- '(': count 올려주고
- ')': count의 값이 0이상이면 뺴주고 이하면 false 리턴
2. 마지막에 count에 값이 1이상이면 false
3. 여기에 해당 안될경우 true
   ```
   for(int i= 0; i<s.length(); i++){
            
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else{
                if(count <= 0){
                    return false;
                }
                count--;
            }
        }
        if(count>0){
            return false;
        }
   ```

## :black_nib: **Review**

- 처음에는 스텍으로 풀려고 했는데 스텍 코드를 까먹어서 스텍을 사용하지 않고 int로 해결

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12909
