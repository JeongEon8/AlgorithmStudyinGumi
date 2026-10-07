# [PGS - Lv1] 02_같은 숫자는 싫어

## ⏰**time**
5분

## :pushpin: **Algorithm**
벡터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 마지막으로 들어온 숫자가 같은 숫자가 들어오면 continue
2. 다른 숫자면 push_back
   ```cpp
   for(int i =1; i < arr.size(); i++){
       if(!answer.empty()){
           if(answer[ptr] == arr[i]){
               continue;
           }
           answer.push_back(arr[i]);
           ptr++;
       }
   }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv1 같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906)
