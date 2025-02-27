# [백준] 1062. 가르침


## ⏰ **time**
50분

## :pushpin: **Algorithm**
백트래킹

## ⏲️**Time Complexity**
O(N)

## :round_pushpin: **Logic**

1. learned 배열에 미리 'antic'의 ASCII 값을 추가함
2. words List에 'antic'을 제외한 알파벳을 추가
3. 읽을 수 있는 단어인지를 확인하고, 모든 알파벳을 읽어낼 수 있다면 count++

```java
private static int countReadableWords() {
    int count = 0;

    for (String word : words) {
        boolean canRead = true;

        // 단어의 모든 글자가 학습된 글자인지 체크
        for (int j = 0; j < word.length(); j++) {
            if (!learned[word.charAt(j) - 'a']) {
                canRead = false;
                break;
            }
        }

        if (canRead) {
            count++;
        }
    }

    return count;
}
```


## :black_nib: **Review**
열심히 하는 모두 너무 멋있으십니다. 저도 열심히 하는 모습 보여드리겠습니다(다음부터)

## 📡**Link**
https://www.acmicpc.net/problem/1062
