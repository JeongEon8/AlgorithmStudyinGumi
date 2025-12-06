# [프로그래머스 - lv2] 파일명 정렬

## ⏰  **time**

60분

## ⏲️**Time Complexity**

$O(N \log N)$

## 풀이

1. 파일명을 `HEAD`, `NUMBER`, `TAIL`로 분리한다.

- `HEAD`: 숫자가 나오기 전까지의 문자열
- `NUMBER`: 연속된 숫자 문자열
- `TAIL`: 이후 모든 문자열

2. 문자열을 분리한 후 `File` 객체에 저장한다.

- `HEAD` 사전순
- `NUMBER` 정수 기준 오름차순
- `HEAD`와 `NUMBER`가 같으면 입력 순서 유지

3. 정렬된 순서대로 원래 origin 문자열을 결과 배열에 담아 반환한다.

```java
for (String file : files) {
    StringBuilder head = new StringBuilder();
    StringBuilder number = new StringBuilder();
    StringBuilder tail = new StringBuilder();
            
    int idx = 0;
            
    // HEAD
    while (idx < file.length() && !(file.charAt(idx) >= '0' && file.charAt(idx) <= '9')) {
        head.append(file.charAt(idx++));
    }
            
    // NUMBER
    while (idx < file.length() && file.charAt(idx) >= '0' && file.charAt(idx) <= '9') {
        number.append(file.charAt(idx++));
    }
            
    // TAIL
    while (idx < file.length()) {
        tail.append(file.charAt(idx++));
    }
            
    fileList.add(new File(file, head.toString(), number.toString(), tail.toString()));
}
        
// 1. HEAD 비교
// 2. NUMBER 비교
fileList.sort((f1, f2) -> {
    int headCompare = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            
    if (headCompare == 0) {
        int num1 = Integer.parseInt(f1.number);
        int num2 = Integer.parseInt(f2.number);
        return Integer.compare(num1, num2);
    }
    return headCompare;
});
```

## :black_nib: **Review**

## 📡**Link**

- <https://school.programmers.co.kr/learn/courses/30/lessons/17686>
