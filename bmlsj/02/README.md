# [백준 - S5] 11723. 집합

## ⏰  **time**
40분

## :pushpin: **Algorithm**
HashSet, 비트 마스킹

## ⏲️**Time Complexity**
- HashSet : 평균 $O(1)$ (최악의 경우 $O(N)$)
- 비트 마스킹 : 항상 $O(1)$

## :round_pushpin: **Logic**

- 정수 1~20으로 구성된 집합을 관리하는 프로그램
- 다음 6가지 명령 수행:
	`add x`, `remove x`, `check x`, `toggle x`, `all`, `empty`

1. HashSet으로 풀이

```java
HashSet<Integer> set = new HashSet<>();

for (int i = 0; i < M; i++) {
    String[] split = br.readLine().split(" ");
    String cmd = split[0];
    int x = split.length > 1 ? Integer.parseInt(split[1]) : 0;

    switch (cmd) {
        case "add": set.add(x); break;
        case "remove": set.remove(x); break;
        case "check": bw.write(set.contains(x) ? "1\n" : "0\n"); break;
        case "toggle":
            if (set.contains(x)) set.remove(x);
            else set.add(x);
            break;
        case "all":
            set.clear();
            for (int j = 1; j <= 20; j++) set.add(j);
            break;
        case "empty": set.clear(); break;
    }
}

```
</br>


2. 비트 마스킹 풀이


```java
int set = 0; // 00000000000000000000

for (int i = 0; i < M; i++) {
    String[] split = br.readLine().split(" ");
    String cmd = split[0];
    int x = split.length > 1 ? Integer.parseInt(split[1]) : 0;

    switch (cmd) {
        case "add": set |= (1 << (x - 1)); break;
        case "remove": set &= ~(1 << (x - 1)); break;
        case "check": bw.write(((set & (1 << (x - 1))) != 0 ? "1\n" : "0\n")); break;
        case "toggle": set ^= (1 << (x - 1)); break;
        case "all": set = (1 << 20) - 1; break;
        case "empty": set = 0; break;
    }
}

```


## :black_nib: **Review**
- 비트 마스킹.. 너무 오랜만이라 가물가물하구..
처음에는 map으로 풀이했는데, 20까지의 정수 뿐이라서 너무 느리고 공간 낭비가 발생한다고 한다.
- 시간 초과 방지를 위해 `BufferedWriter`를 사용해야 한다.
	- 내부 버퍼에 문자열을 일시적으로 저장하고 `bw.flush()` 할 때, 한꺼번에 출력

## 📡 Link
https://www.acmicpc.net/problem/11723