# [PGS - Lv2] 02_뒤에 있는 큰 수 찾기

## ⏰**time**

- 23분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 스택에 넣어서 하나씩 꺼내서 비교 만약 클작을 경우 뒤는 검사 안함
   ```
   while(!stack.isEmpty()){
                   
                   int[] data = stack.pop();
                   if(data[1]<num){
                       answer[data[0]]=num;
                   }else{
                       stack.push(data);
                       break;
                   }
               }
   ```

## :black_nib: **Review**

- 처음에는 하나씩 다 비교를 했더니  1,000,000* 1,000,000 이라서 시간 초과뜸

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154539
