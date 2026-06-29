# [PGS - Lv2] 01_[3차] 압축

## ⏰**time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 먼저 사전에 알파벳 A~Z를 1~26번 인덱스로 저장한다.
   ```java
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), index++);
        }
   ```

2. 메시지의 처음부터 순차적으로 탐색한다.
    start : 현재 탐색 시작 위치
    end : 탐색 끝 위치
    res : 사전에서 찾은 가장 긴 문자열
   ```java
        int end = 0;
        for(int start = 0; start < msg.length(); start++){
            end = start + 1;
            String res = "";
   ```

3. 현재 위치에서 문자열을 한 글자씩 늘려가며 사전에 존재하는지 확인한다.
   ```java
                String key = msg.substring(start, end);
                if(dictionary.containsKey(key)){
                    res = key;
                    end++;
                }
   ```
4. 가장 긴 문자열 출력 후 새로운 문자열 등록
   ```java
                else{
                    answerList.add(dictionary.get(res));
                    dictionary.put(key, index++);
   ```

5. 가장 긴 문자열 출력 후 새로운 문자열 등록
   ```java
                    start = end - 2;
                    break;
                }
   ```

6. 문자열 끝까지 도달한 경우
   ```java
                if(end > msg.length()){
                    answerList.add(dictionary.get(res));
                    start = end - 2;
                    break;
                }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17684
