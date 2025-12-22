# [백준 - S3] 2149. 암호 해독

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 구현
- 문자열
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
1. 키의 각 알파벳을 인덱스 순서와 같이 KeyAlphabet으로 저장한다. 조건에 맞게 알파벳순, 동일한 알파벳일시 인덱스가 빠른 순으로 정렬한다.  
2. 암호문을 설명의 표대로 넣고 키의 정렬 후 인덱스와 원래 인덱스로 역산한다.
```java
static class KeyAlphabet implements Comparable<KeyAlphabet> {
    char alphabet;
    int idx;

    public KeyAlphabet(char alphabet, int idx) {
        this.alphabet = alphabet;
        this.idx = idx;
    }

    @Override
    public int compareTo(KeyAlphabet o) {
        if (this.alphabet == o.alphabet) {
            return this.idx - o.idx;
        }
        return this.alphabet - o.alphabet;
    }

}

Arrays.sort(keyAlphabets);
String crypt = in.readLine();
int m = crypt.length();
int r = m / n;
char[][] cryptTable = new char[r][n];
int cryptIdx = 0;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < r; j++) {
        cryptTable[j][i] = crypt.charAt(cryptIdx++);
    }
}
char[][] plainText = new char[r][n];
for (int i = 0; i < n; i++) {
    int plainIdx = keyAlphabets[i].idx;
    for (int j = 0; j < r; j++) {
        plainText[j][plainIdx] = cryptTable[j][i];
    }
}
```  
## :black_nib: **Review** 
평문을 암호문으로 바꾸는 문제인줄 알았으나 암호문을 평문으로 역산하는 문제였다..
## 📡**Link**
https://www.acmicpc.net/problem/2149