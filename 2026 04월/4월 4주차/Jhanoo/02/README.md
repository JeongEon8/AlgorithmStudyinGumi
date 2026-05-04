# [프로그래머스 - Lv2] JadenCase 문자열 만들기

## ⏰**time**

14분

## :pushpin: **Algorithm**

- 문자열
- 구현

## ⏲️**Time Complexity**

$O(L)$  
(\(L\): 문자열 길이)

## :round_pushpin: **Logic**

1. 문자열을 `char[]`로 바꾼 뒤, 현재 문자가 “단어의 첫 글자”인지 여부를 `isFirst`로 관리합니다.

2. 공백을 만나면 다음 문자가 단어의 첫 글자가 되므로 `isFirst = true`로 갱신합니다.  
   공백이 연속으로 나와도 공백을 그대로 두고 플래그만 유지하므로 조건을 만족합니다.

```java
if (cur == ' ') {
    isFirst = true;
    continue;
}
```

3. 단어의 첫 글자면 `toUpperCase`, 그 외는 `toLowerCase`로 변환합니다.  
   첫 글자가 숫자여도 `toUpperCase`는 그대로 반환하므로(숫자는 변화 없음) 문제 조건을 자연스럽게 처리합니다.

```java
if (isFirst) {
    str[i] = Character.toUpperCase(cur);
    isFirst = false;
} else {
    str[i] = Character.toLowerCase(cur);
}
```

4. 최종 `char[]`를 문자열로 변환해 반환합니다.

## :black_nib: **Review**

-

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12951
