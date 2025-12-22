# [백준- G4] 9935. 문자열 폭발
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
문자열 + 스택

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- StringBuilder를 스택처럼 사용하기
- 추가한 문자가 폭탄 문자열의 마지막 문자와 같은 경우, 뒤에서부터 폭탄 문자열이 포함되어 있는지 확인
- 포함되어 있다면 해당 문자열 제거
```java
StringBuilder sb = new StringBuilder();
for (char c : str.toCharArray()) {
    sb.append(c);
    if (sb.length() >= bombLen && c == bombStr.charAt(bombLen - 1)) {
        boolean isBomb = true;
        // 뒤에서부터 폭탄 문자열이 포함되어있는지 확인
        for (int i = 1; i <= bombLen; i++) {
            if (bombStr.charAt(bombLen - i) != sb.charAt(sb.length() - i)) {
                isBomb = false;
                break;
            }
        }
        if (isBomb) sb.delete(sb.length() - bombLen, sb.length());
    }
}
System.out.println(sb.toString().isEmpty() ? "FRULA" : sb);
```

## :black_nib: **Review**
해당 문자열만 제거하면 되겠다고 간단하게 생각해서 문자열 함수 그냥 그대로 썼는데 시간초과 & 메모리 초과가 난다,,
생각을 하고 풀어야 하는 문제였다 ㅎㅎ..

## 📡**Link**
- https://www.acmicpc.net/problem/9935
