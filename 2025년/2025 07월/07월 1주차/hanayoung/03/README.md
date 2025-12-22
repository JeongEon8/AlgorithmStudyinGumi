# [백준 - G4] 9935. 문자열 폭발

## ⏰  **time**
50분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. stringBuilder에 하나씩 붙이고, 폭발 문자열의 길이보다 같거나 커져서 비교할 수 있게 되었을 때, 끝 문자열이 폭발 문자열과 동일하면 stringBuilder에서 제거
```java
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if(sb.length() >= bomb.length()) {
                if(sb.substring(sb.length()-bomb.length()).equals(bomb)) sb.delete(sb.length()-bomb.length(), sb.length());
            }
        }
```
2. 마지막으로 크기 비교해서 0이면 "FRULA" append하기
```java
       if(sb.length() == 0) sb.append("FRULA");
        System.out.println(sb);
```

## :black_nib: **Review**
- 처음엔 문자열 비교했더니(replaceAll 사용) 메모리 초과 이슈.. replaceAll은 새 문자열 객체를 계속해서 생성하여 메모리 초과 일으킨다고 함
- 이렇게는 안 풀어봤는데 새롭다

## 📡 Link
https://www.acmicpc.net/problem/9935
