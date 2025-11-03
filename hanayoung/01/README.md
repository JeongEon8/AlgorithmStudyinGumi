# [프로그래머스 - Lv2] 모음사전

## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(k^(L+1))$

## :round_pushpin: **Logic**
1. 전역적으로 가능한 단어들을 담을 hashMap과 순번을 의미할 order 변수 생성
```java
    static Map<String, Integer> hashMap;
    static int order = 1;
```
2. r이 6일 경우, 가능한 최대 길이이므로 탈출
3. word.length()만큼 돌면서 hashMap에 넣은 적 없는 단어라면 hashMap에 단어를 key로, order를 value로 담고 order++
4. makeOrder 함수 호출 
```java
    public void makeOrder(String str, String word, int r) {
        if(r == 6) return;
        for(int i = 0; i < word.length(); i++) {
            if(str.length() > 0 && hashMap.get(str) == null) {
                hashMap.put(str, order);
                order++;
            }
            makeOrder(str+word.charAt(i), word, r+1);
        }
    }
```


## :black_nib: **Review**
- 알고리즘 고득점 kit 정복하기 ! 완탐 돌아! 

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/84512
