# [프로그래머스 - Lv.2] 의상
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
가능한 모든 가짓수는 입거나 말거나이므로 의상의 종류별로 (각 의상의 개수+1) 씩 곱해서 다 안 입은 경우 한 가지를 뺄 것.
1. 의상의 종류를 저장할 HashMap 생성
2. 주어진 clothes를 돌며 이미 존재한 의상의 종류일 경우엔 value를 1 더하고, 존재하지 않을 경우 value가 1이고, key가 의상의 종류인 값을 hashmap에 추가
3. sets를 돌며 +1씩 더한 값을 곱하고 1을 뺀 값을 반환

## :black_nib: **Review**
- 생각만 잘하면 쉬운 문제

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/42578
