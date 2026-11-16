# [PGS - Lv1] 01_이상한 문자 만들기

## ⏰**time**
10분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. 띄어쓰기가 나올때까지 한자씩 수집하여 단어를 저장한다.
2. 단어가 완성되면 0이거나 짝수자리에서 대문자를, 홀수자리에는 소문자를 아스키코드를 이용해 저장한다.
   ```cpp
   string trans(string word)
   {
       string result = "";
       for(int j = 0; j < word.length(); j++)
       {
           if(j == 0 || j % 2 == 0){
               if(word[j] >= 65 && word[j] <= 90)
               {
                   result += word[j];
               }
               else{
                   result += word[j] - 32;    
               }
           }
           else{
               if(word[j] >= 65 && word[j] <= 90)
               {
                   result += word[j] + 32;
               }
               else{
                   result += word[j];    
               }
           }
       }
       return result;
   }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv1 이상한 문자 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12930)
