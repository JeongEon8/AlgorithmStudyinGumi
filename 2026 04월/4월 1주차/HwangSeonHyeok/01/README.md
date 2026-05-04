# [백준 - S5] 21966. (중략)


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 구현
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
중략이 가능한 경우 12~뒤에서 13번째 글자사이에 .이 없어야 그사이가 모두 같은 문장이다. 이를 분기처리하여 답을 출력한다.
```java
if (n <= 25) {
    System.out.println(s);
} else {
    boolean isSameSentence = true;
    for (int i = 11; i <= n - 13; i++) {
        if (s.charAt(i) == '.') {
            isSameSentence = false;
            break;
        }
    }
    if (isSameSentence) {
        String prefix = s.substring(0, 11);
        String suffix = s.substring(n - 11);
        System.out.println(prefix + "..." + suffix);
    } else {
        String prefix = s.substring(0, 9);
        String suffix = s.substring(n - 10);
        System.out.println(prefix + "......" + suffix);
    }
}
```

## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/21966