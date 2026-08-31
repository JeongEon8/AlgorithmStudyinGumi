# [PGS - Lv2] 01\_[3차] 압축

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. (풀이 방식을 작성해주세요.)

```java
HashMap<String, Integer> dict = new HashMap();
for (char c = 'A'; c <= 'Z'; c++) {
   dict.put(c + "", c - 'A' + 1);
}
```

1. 1글자는 무조건 사전에 있으니, 길이가 2인 문자부터 사전에 등록한다.
2. `start` 위치부터 글자를 하나씩 붙여, 사전에 존재하는 가장 긴 문자열을 `find`에 넣는다.
3. 사전에 없는 새 단어를 만나면(`w+c`), 사전에 등록해 색인번호를 추가한다.
4. `find`의 색인번호를 `result`에 추가하고, 처리된 길이만큼 start 포인터를 이동시킨다.

```java
int start = 0;
int idx = 27;
while (start < msg.length()) {

   StringBuilder sb = new StringBuilder();
   String find = "";
   int len = 0;

   for (int i = start; i < msg.length(); i++) {
        // 글자 추가
        sb.append(msg.charAt(i));
        String curr = sb.toString();

        // 사전에 있으면
        if (dict.containsKey(curr)) {
            find = curr;
            len++;
            continue;
        } else {
            dict.put(sb.toString(), idx++);
            break;
        }
   }

   result.add(dict.get(find));
   start += len;
}
```

## :black_nib: **Review**

-

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/17684>
