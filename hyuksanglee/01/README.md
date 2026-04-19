# [백준 - S2] 15666. N과 M (12)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- dfs
- set
- 정렬

## ⏲️**Time Complexity**

$O(N \log N)$

## :round_pushpin: **Logic**

set을 활용하여 중복값을 제거해주고 정렬해서 하나씩 꺼내서 숫자를 만들고 출력해준다.

```java
	fun dfs(start:Int, depth: Int, M:Int){
    if (depth == M) {
        for (i in 0 until M) {
            sb.append(resultArr[i]).append(" ")
        }
        sb.append("\n")
        return
    }

    for (i in start until list.size) {
        resultArr[depth] = list[i]
        dfs(i, depth + 1, M)
    }
}
```

## :black_nib: **Review**
- 코틀린은 set 타입에서 .sorted()를 활용하면 정렬상태의 리스트로 만들어주는데 완전 신세계

## 📡**Link**

https://www.acmicpc.net/problem/15666
