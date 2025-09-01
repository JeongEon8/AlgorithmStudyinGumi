# [백준 - S5] 32292. ABB to BA (Easy) 

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 문자열
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**
ABB를 BA로 바꾸는 과정을 ABB가 나올 수 있는 범위에서 ABB가 없어질때까지 반복한다.  

```java
int n = Integer.parseInt(in.readLine());
String str = in.readLine();
StringBuilder tmp = new StringBuilder();
for (int j = 0; j < str.length(); j++) {
    char c = str.charAt(j);
    tmp.append(c);
    int idx = 0;
    while (true) {
        int abbIdx = tmp.indexOf("ABB", idx);
        if (abbIdx == -1) {
            break;
        }
        tmp.replace(abbIdx, abbIdx + 3, "BA");
        idx = Math.max(0, abbIdx - 2);
    }
}
sb.append(tmp).append("\n");
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/32292