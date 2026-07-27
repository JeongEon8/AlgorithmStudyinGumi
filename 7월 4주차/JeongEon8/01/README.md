# [PGS - Lv1] 01_서울에서 김서방 찾기

## ⏰**time**
5분

## :pushpin: **Algorithm**
String

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. Seoul 배열에 "Kim"있는 번호를 저장
   ```cpp
    for(int i = 0; i < cnt; i++){
        if(seoul[i] == "Kim"){
            answer += to_string(i);
            break;
        }
    }
   ```

## :black_nib: **Review**
- 히히 집 앞에 값싼 코노가 있어요 좋아용
- 단점은, 담배냄새가 조금 난다는 거임.

## 📡 Link
[프로그래머스 Lv1 서울에서 김서방 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12919)
