# [백준 - S5] 단어 정렬
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 길이 비교하고, 사전 순으로 정렬하기 위해 Comparable implements하기
```java
    static class Word implements Comparable<Word>{
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if(word.length() < o.word.length()) return -1;
            else if(word.length() > o.word.length()) return 1;
            else{
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) < o.word.charAt(i)) {
                        return -1;
                    }
                    else if(word.charAt(i) > o.word.charAt(i)) return 1;
                }
                return 0;
            }
        }
    }
```
3. 입력받은 문자열들은 queue에 추가
4. List에 queue의 값을 꺼내어 담고, 이미 list에 존재하지 않는 경우에만 list에 추가하고, 프린트

## :black_nib: **Review**
- 우선순위큐 조아

## 📡 Link
https://www.acmicpc.net/problem/1181
