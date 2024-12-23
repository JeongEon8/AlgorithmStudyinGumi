# [백준] 1501. 영어 읽기


## ⏰ **time**
40분

## :pushpin: **Algorithm**
자료 구조, 문자열

## ⏲️**Time Complexity**
O(n * m * k * log(k))

## :round_pushpin: **Logic**
단어의 양끝은 그대로 두고, 그 사이에 끼인 문자들을 알파벳순으로 정렬시켜주면 구성요소가 같은 단어들을 확인할 수 있다. <br/>
문장이 입력될 시 공백을 기준으로 단어별 경우의 수를 알아내고, 곱하면 전체 경우의 수가 나온다. 
```java
    private static String separate(String word) {
        if (word.length() <= 2) {
            return word; 
        }
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        char[] middle = word.substring(1, word.length() - 1).toCharArray();
        Arrays.sort(middle);
        return first + new String(middle) + last;
    }
```


## :black_nib: **Review**
로직이 어렵지 않은 문제였다.

## 📡**Link**
https://www.acmicpc.net/problem/1501
