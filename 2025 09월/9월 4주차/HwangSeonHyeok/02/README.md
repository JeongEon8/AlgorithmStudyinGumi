# [백준 - G4] 1662. 압축

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 자료 구조
- 재귀

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
Pair는 압축 해제 후의 길이와 각 압축된 문자열의 어디까지 압축을 해제했는지 idx를 저장하고 있는 자료구조이다.  
'('를 만나면 재귀로 그 안에 든 문자열의 길이를 세고 그 ')'로 압축 이 끝나는 지점을 같이 return값으로 돌려줘 그다음으로 봐야할 인덱스와 압축곱 값을 구한다.

```java
static Pair calculate(int idx) {
    int length = 0;
    for (int i = idx; i < s.length; i++) {
        char current = s[i];
        if (current == '(') {
            int mult = s[i - 1] - '0';
            Pair p = calculate(i + 1);
            length += p.length * mult - 1;
            i = p.idx;
        } else if (current == ')') {
            return new Pair(length, i);
        } else {
            length++;
        }
    }
    return new Pair(length, s.length - 1);
}
```
## :black_nib: **Review**
나는 재귀함수로 풀었으나 스택으로 푸는 방법도 있는거 같다.

## 📡**Link**
https://www.acmicpc.net/problem/1662