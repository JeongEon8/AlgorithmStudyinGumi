# [백준 - S1] 1141. 접두사

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

- 접두사 관계이므로 이웃한 단어끼리 비교하면 간단해진다.
- `접두어가 아닌 단어 수 = 최대 부분집합 크기`

1. 문자열 배열을 정렬한다.
2. 한 단어의 접두사가 다음 위치들의 접두사가 같으면 `isPrefix = true`
3. 접두사가 같지 않은 단어들의 수를 구한다.

```java
Arrays.sort(words);
int count = 0;

for (int i = 0; i < N; i++) {
   boolean isPrefix = false;
   for(int j = i + 1; j < N; j++) {
        if (words[j].startsWith(words[i])) {
            isPrefix = true;
            break;
        }
   }

   if (!isPrefix) count++;
}

System.out.println(count);
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/1141](https://www.acmicpc.net/problem/1141)
