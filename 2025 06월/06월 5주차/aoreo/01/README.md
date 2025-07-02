# [백준 - S4] 1620. 나는야 포켓몬 마스터 이다솜

## ⏰  **time**
40분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(n+m)$

## :round_pushpin: **Logic**
1. 순번을 키로 갖는 해시맵과 이름을 키로 갖는 해시맵 사용
```java
HashMap<String, Integer> guideString = new HashMap<>();
HashMap<Integer, String> guideInteger = new HashMap<>();
```
2. 첫 번째 글자가 숫자인지 아닌지 판별해서 숫자면 guideInteger에서, 문자면 guideString에서 꺼내기
```java
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();
            Character firstLetter = tmp.charAt(0);
            if(Character.isDigit(firstLetter)) {
                System.out.println(guideInteger.get(Integer.valueOf(tmp)));
            } else {
                System.out.println(guideString.get(tmp));
            }
        }
```

## :black_nib: **Review**
- 시간초과 이슈 눈물 오랜만의 해시라 생각이 안났네
- 별의별짓 다 하다가 된 건데 생각해보면 굳이 hashmap 두 개 쓸 필요가..? 배열 써도 되었을듯

## 📡 Link
https://www.acmicpc.net/problem/1620
