# [백준 - S4] 7656. 만능 오라클

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 문자열
- 파싱


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
정규식으로 앞에 문자가 있고 대문자인 곳을 기준으로 파싱한다.  
What is로 시작하고 ?로 끝나는 문장을 앞뒤로 자르고 Forty-two,와 .을 붙인다.
```java
String[] sentences = in.readLine().split("(?<=.)(?=[A-Z])");
for (String sentence : sentences) {
    String trimedString = sentence.trim();
    if (trimedString.startsWith("What is") && trimedString.endsWith("?")) {
        String ans = "Forty-two" + trimedString.substring(4, trimedString.length() - 1) + ".\n";
        sb.append(ans);
    }
}
```  


## :black_nib: **Review**  
split할 정규식은 찾아봤다..  
공백 제거를 안했더니 출력 형식 오류가 났었다.
## 📡**Link**
https://www.acmicpc.net/problem/7656