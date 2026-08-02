# [PGS - Lv1] 01_핸드폰 번호 가리기

## ⏰**time**
5분

## :pushpin: **Algorithm**
string

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 뒷자리 4자리가 아닌 곳의 위치일 떄는 *을, 그 외에는 해당 자리의 번호를 넣는다.
   ```cpp
    for(int i= 0; i < phone_number.length(); i++){
        if(i < star_size){
            answer += "*";
        }
        else{
            answer += phone_number[i];
        }
    }
   ```

## :black_nib: **Review**
- 뭔가! 예카를 수집하고 싶어요.. 줍줍

## 📡 Link
[프로그래머스 lv1 핸드폰 번호 가리기](https://school.programmers.co.kr/learn/courses/30/lessons/12948)
