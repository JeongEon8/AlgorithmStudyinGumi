# TEST

## ⏰**time**

(걸린 시간을 작성해주세요.)

## :pushpin: **Algorithm**

(알고리즘을 작성해주세요.)

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. (풀이 방식을 작성해주세요.)
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
   ```

   ```
   if(count>0){
               return false;
           }
   ```

## :black_nib: **Review**

- (소감을 작성해주세요.)

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12909
