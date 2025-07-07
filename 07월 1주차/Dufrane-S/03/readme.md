# [백준- S3] 20920. 영단어 암기는 괴로워
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
- 자바의 Comparable을 통해 구현
```java
  public int compareTo(Word word) {
        if (this.count > word.count) {
            return -1;
        } else if (this.count < word.count) {
            return 1;
        }

        if (this.word.length() > word.word.length()) {
            return -1;
        } else if (this.word.length() < word.word.length()) {
            return 1;
        }
        return this.word.compareTo(word.word);
    }
```

## :black_nib: **Review**
- 

## 📡**Link**
- https://www.acmicpc.net/problem/20920
