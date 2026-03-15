# [백준 - S5] 1652. 누울 자리를 찾아라


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 문자열
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
행은 라인단위로 받을때 'X'를 기준으로 나눠서 누울 수 있는 공간 수를 카운팅하고 입력받으면서 배열에 갯수를 적어가면서 카운팅한다.
```java
int rows = 0;
int columns = 0;
int[] columnSpace = new int[n];
for (int i = 0; i < n; i++) {
    String line = in.readLine();
    String[] split = line.split("X");
    for (String space : split) {
        if (space.length() > 1) {
            rows++;
        }
    }
    for (int j = 0; j < n; j++) {
        char c = line.charAt(j);
        if (c == 'X') {
            if (columnSpace[j] > 1)
                columns++;
            columnSpace[j] = 0;
        } else {
            columnSpace[j]++;
        }
    }
}
for (int i = 0; i < n; i++) {
    if (columnSpace[i] > 1)
        columns++;

}
```

## :black_nib: **Review** 
더 깔끔하게 풀 방법이 있을거 같다.

## 📡**Link**
https://www.acmicpc.net/problem/1652