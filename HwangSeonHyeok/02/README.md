# [백준 - S5] 25178. 두라무리 휴지

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 문자열


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
조건대로 첫글자와 마지막 글자가 같은지 확인하고, a,e,i,o,u를 제외한 문자열이 같은지 확인한다. 재배열해서 서로 만들 수 있는지 여부는 두 단어의 알파벳 갯수가 모두 동일한지 확인한다.

```java
static boolean solve(String str1, String str2) {
    if (str1.charAt(0) != str2.charAt(0) || str1.charAt(n - 1) != str2.charAt(n - 1)) {
        return false;
    }
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    for (int i = 0; i < n; i++) {
        char c1 = str1.charAt(i);
        char c2 = str2.charAt(i);
        if (c1 != 'a' && c1 != 'e' && c1 != 'i' && c1 != 'o' && c1 != 'u') {
            sb1.append(c1);
        }
        if (c2 != 'a' && c2 != 'e' && c2 != 'i' && c2 != 'o' && c2 != 'u') {
            sb2.append(c2);
        }
        arr[c1 - 'a']++;
        arr[c2 - 'a']--;
    }
    if (!sb1.toString().equals(sb2.toString())) {
        return false;
    }
    for (int i = 0; i < 26; i++) {
        if (arr[i] != 0)
            return false;
    }

    return true;
}
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25178