# [프로그래머스 - Lv2] 12981. 영어 끝말잇기

## ⏰ **time**
18분

## :pushpin: **Algorithm**
문자열, SET

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. set 자료형을 이용해 중복된 문자가 들어왔는지 확인한다.
2. 이전 string의 맨 뒷글자와 지금 string의 맨 앞글자가 동일한지 확인한다.
3. 현 string이 한글자 초과인지 확인한다.
```cpp
        // 중복
        iter = s.find(words[i]);
        if(iter != s.end()){
            answer[0] = turn + 1;
            answer[1] = cnt[turn];
            break;
        }
        
        // 끝말잇기 규칙 위반
        int last_length = words[i-1].length();
        if(words[i - 1][last_length - 1] != words[i][0]) {
            answer[0] = turn + 1;
            answer[1] = cnt[turn];
            break;
        }
        
        // 한글자 단어 위반
        if(words[i].length() <= 1){
            answer[0] = turn + 1;
            answer[1] = cnt[turn];
            break;
        }
```

## :black_nib: **Review**
- 요새 하늘 너무 예쁘지 않아요?
- 산에 녹음이 예쁘게졌어요. 딱 이번달까지가 등산하기 좋은 달입니다!
- 용마산 가봐요~

## 📡 Link
[프로그래머스 레벨2 영어 끝말잇기](https://school.programmers.co.kr/learn/courses/30/lessons/12981)
