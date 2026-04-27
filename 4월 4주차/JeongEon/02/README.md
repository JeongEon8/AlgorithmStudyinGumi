# [프로그래머스 - Lv2] 12951.JadenCase 문자열 만들기

## ⏰ **time**
16분

## :pushpin: **Algorithm**
문자

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. string 받은 대로 돌면서 이전이 " " 띄어쓰기거나 0번째면 대문자로 만들고, 그외는 소문자로 만들어!
```cpp
  for(int i = 0; i < s.length(); i++){
      if((i == 0) || (i > 0 && s[i-1] == ' ')) {
          if(s[i] >= 97 && s[i] <= 122){
              s[i] = s[i] - 32;
          }
      }
      else if(s[i] >= 65 && s[i] <= 90){
          s[i] = s[i] + 32;
      }
         
      answer += s[i];
  }
```

## :black_nib: **Review**
- 8번째 테스트 케이스에서 실패되길래 뭔가 했더니, 띄어쓰기가 여러개 들어올 수 있다는 거였다!
- 모두모두 조건을 잘 읽어봅시다~

## 📡 Link
[프로그래머스 레벨2 JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)
