# [백준 - S5] 14405. 피카츄

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
 
글자수와 현재 철자에 맞게 pi, ka, chu가 될 수 있는지 확인한다. 만약 아닌게 나오면 불가능하므로 종료한다.
```java
for (int i = 0; i < pika.length(); i++) {
    if (i == pika.length() - 1) {
        isable = false;
        break;
    }
    if (pika.charAt(i) == 'p') {
        if (!"pi".equals(pika.substring(i, i + 2))) {
            isable = false;
            break;
        }
        i += 1;
    } else if (pika.charAt(i) == 'k') {
        if (!"ka".equals(pika.substring(i, i + 2))) {
            isable = false;
            break;
        }
        i += 1;
    } else if (i < pika.length() - 2 && pika.charAt(i) == 'c') {
        if (!"chu".equals(pika.substring(i, i + 3))) {
            isable = false;
            break;
        }
        i += 2;
    } else {
        isable = false;
        break;
    }
}
```

## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/14405