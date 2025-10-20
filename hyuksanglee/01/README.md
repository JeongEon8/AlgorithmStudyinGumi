# [백준 - S5] 29812. 아니 이게 왜 안 돼

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디 알고리즘
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
'H','Y','U' 각각의 알파벳이 나올 때마다 그때까지 HYU 이외의 알파벳을 일일히 delete로 지우는데 드는 에너지와 드래그하고 지우는데 드는 에너지중 작은 수치만큼 더하고 map에 나온 횟수를 기록한다. 사용한 에너지의 최소합과 3개중 가장 적게 나온 항목의 수를 출력한다.
```java
    Map<Character, Integer> map = new HashMap<>();
    map.put('H', 0);
    map.put('Y', 0);
    map.put('U', 0);
    int energy = 0;
    int others = 0;
    for (int i = 0; i < n; i++) {
        char c = str.charAt(i);
        if (map.containsKey(c)) {
            energy += Math.min(others * d, m + d);
            others = 0;
            map.put(c, map.get(c) + 1);
        } else {
            others++;
        }
    }
    energy += Math.min(others * d, m + d);
```

## :black_nib: **Review**  
## 📡**Link**
https://www.acmicpc.net/problem/29812