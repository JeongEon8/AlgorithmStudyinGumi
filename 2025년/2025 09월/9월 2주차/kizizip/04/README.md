# [프로그래머스 - 2] 영어 끝말잇기


## ⏰ **time**
20분

## :pushpin: **Algorithm**
구현, 자료구조

## ⏲️**Time Complexity**
O(L)

## :round_pushpin: **Logic**
1. HashSet에 단어 저장
2. 단어 순회 (count++)
3. 첫 단어는 그냥 저장 .. 이후 단어부터는
- 이전 단어 끝 글자와 현재 단어 첫 글자 비교
- 이미 나온 단어인지 검사
- 둘 중 하나라도 위반이면 탈락, 반복 중단
4. 탈락 지점(count) 기준으로
- 사람 번호 = count % n == 0 ? n : count % n
- 차례 = count / n + (count % n == 0 ? 0 : 1)
5. 끝까지 이상 없으면 [0, 0] 반환

## :black_nib: **Review** 
그려

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12981
