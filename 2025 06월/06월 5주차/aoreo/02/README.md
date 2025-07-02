# [백준 - S4] 20920. 영단어 암기는 괴로워

## ⏰  **time**
20분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(N·L + K·L·logK)$

## :round_pushpin: **Logic**
1. 단어의 길이가 M 이상이고, hashmap에 존재하면 value를 1 증가시켜 넣고, 존재하지 않는다면 value를 1로 삽입
```java
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String word = st.nextToken();
            if (word.length() >= M) {
                if (hashMap.get(word) != null) {
                    hashMap.put(word, hashMap.get(word) + 1); 
                }else {
                    hashMap.put(word, 1);
                }
            }
        }
```
2. 우선순위큐에 삽입
```java
        for (String ele : hashMap.keySet()) {
            pQueue.add(new Word(ele, hashMap.get(ele)));
        }
```
3. Word 클래스를 만들어서 정렬 기준, 자주 나올수록, 길이가 길수록, 알파벳 사전 상 앞일수록 앞으로 배치
```java
    static class Word implements Comparable<Word> {

        int cnt;
        String name;

        Word(String name, int cnt) {
            this.cnt = cnt;
            this.name = name;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt > o.cnt) {
                return -1; 
            }else if (this.cnt == o.cnt) {
                if(this.name.length() > o.name.length()) return -1;
                else if(this.name.length() == o.name.length()) {
                    if(this.name.compareTo(o.name) < 0) return -1;
                }
            }
            return 1;
        }
    }
```
4. 하나씩 꺼내서 stringbuilder에 append해서 출력하기

## :black_nib: **Review**
- 너무 안돼서 왜 안되지했더니 또 stringbuilder....

## 📡 Link
https://www.acmicpc.net/problem/20920
