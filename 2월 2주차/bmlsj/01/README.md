# [백준 - S3] 20920. 영단어 암기는 괴로워

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

```java
List<String> keySet = new ArrayList<String>(words.keySet());
keySet.sort((o1, o2) -> {
    if (words.get(o1) != words.get(o2)) {
    return words.get(o2) - words.get(o1); // 내림차순
    }

    if (o1.length() != o2.length()) { // 길이
    return o2.length() - o1.length(); // 내림차순
    }

    return o1.compareTo(o2); // 사전순
});

BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
for (String key : keySet) {
    bw.write(key + "\n");
}
bw.flush();
bw.close();
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/20920](https://www.acmicpc.net/problem/20920)
