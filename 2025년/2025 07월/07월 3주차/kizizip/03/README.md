# [백준 - S4] 17219. 비밀번호 찾기

## ⏰ **time**
5분

## :pushpin: **Algorithm**
O(n+m)

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1. `passwords`라는 맵 생성
2. 키값(사이트)과 비밀번호 삽입 (`passwords.put`)
3. 키값으로 꺼내기 (`passwords.get`)
```java
        for (int i = 0; i < n; i++) {
            String[] entry = br.readLine().split(" ");
            passwords.put(entry[0], entry[1]);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            String password = passwords.get(site);
            System.out.println(password);
        }
```


## :black_nib: **Review**  
코테에 이런 문제만 나왔으면 좋겠어요! 어림도 없죠!

## 📡**Link**
https://www.acmicpc.net/problem/17219
