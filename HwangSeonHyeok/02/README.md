# [백준 - S3] 1213. 팰린드롬 만들기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘
- 문자열
- 홀짝성

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
홀수인 알파벳의 갯수가 1개 이하인 경우만 펠린드롬을 만들 수 있다.  
사전순을 위해 앞에서부터 그 알파뱃 갯수/2개씩 넣어 시작부분을 만든다. 홀수인게 있으면 가운데, 그리고 시작부분을 뒤집은 부분을 합쳐서 팰린드롬을 만든다.
```java
for (int i = 0; i < s.length(); i++) {
    char alph = s.charAt(i);
    alphCount[alph - 'A']++;
}
int oddCount = 0;
int oddIndex = -1;
for (int i = 0; i < 26; i++) {
    if (alphCount[i] % 2 == 1) {
        oddCount++;
        oddIndex = i;
    }
}
if (oddCount > 1) {
    System.out.println("I'm Sorry Hansoo");
} else {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < alphCount[i] / 2; j++) {
            sb.append((char) ('A' + i));
        }
    }
    String end = sb.reverse().toString();
    sb.reverse();
    if (oddIndex != -1)
        sb.append((char) ('A' + oddIndex));
    sb.append(end);
    System.out.println(sb);
}
```
## :black_nib: **Review**

## 📡**Link**
https://www.acmicpc.net/problem/1213