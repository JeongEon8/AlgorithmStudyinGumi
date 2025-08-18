# [백준 - S3] 9536. 여우는 어떻게 울지?

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 집합과 맵
- 파싱
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
"동물이름 goes 울음소리"의 형태로 입력이 주어지므로 울음소리를 파싱해서 key로 map에 저장한다.  
모든 울음소리를 저장하고 첫번째 녹음된 소리에서 map에 포함되지 않은 소리들을 출력한다.
```java
String question = "what does the fox say?";
for (int i = 0; i < n; i++) {
    String[] growls = in.readLine().split(" ");
    Map<String, Boolean> map = new HashMap<>();
    while (true) {
        String line = in.readLine();
        if (line.equals(question))
            break;
        String[] split = line.split(" ");
        map.put(split[2], true);
    }
    for (String growl : growls) {
        if (!map.containsKey(growl))
            sb.append(growl).append(" ");
    }
    sb.append("\n");
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/9536