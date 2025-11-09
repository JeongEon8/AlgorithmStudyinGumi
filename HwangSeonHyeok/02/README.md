# [백준 - S4] 18404. 현명한 나이트 

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 문자열
- 정렬
- 파싱

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
숫자가 아닌 문자열들을 기준으로 파싱한다.  
길이가 100까지 가능하므로 BigInteger를 사용한다.  
모두 리스트에 넣고 정렬한다.
```java
for (int i = 0; i < n; i++) {
    String[] str = in.readLine().split("\\D+");
    for (String numStr : str) {
        if (!numStr.isEmpty()) {
            ans.add(new BigInteger(numStr));
        }
    }

}
Collections.sort(ans);
```
## :black_nib: **Review**
split 정규식은 구글링 좀 했습니다

## 📡**Link**
https://www.acmicpc.net/problem/2870