# [PGS - Lv2] 01_3월에 태어난 여성 회원 목록 출력하기

## ⏰**time**

10분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(1)$ 

## :round_pushpin: **Logic**

1. 그냥 3월인사람은 MONTH로 여성은 GENDER로 폰번호는 TLNO로 필터링
   ```
   SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE MONTH(DATE_OF_BIRTH)=3 
AND GENDER = 'W'
AND TLNO IS NOT NULL;
   ```

## :black_nib: **Review**

- 쉽네요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/131120
