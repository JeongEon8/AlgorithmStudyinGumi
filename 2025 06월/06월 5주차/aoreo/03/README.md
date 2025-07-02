# [백준 - S5] 11723. 집합

## ⏰  **time**
50분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 1부터 20까지를 key로 갖고 value로 false를 갖는 hashMap 생성
```java
        for (int j = 1; j <= 20; j++) {
            trueMap.put(j, true);
            falseMap.put(j, false);
            hashMap.put(j, false);
        }
```
2. command에 따라 hashMap의 value 변경. 
```java
            if (command.equals("add")) {
                hashMap.put(Integer.valueOf(st.nextToken()), true);
            } else if (command.equals("remove")) {
                hashMap.put(Integer.valueOf(st.nextToken()), false);
            }
```
3. command가 "check"일 경우 stringbuilder에 추가
```java
else if (command.equals("check")) {
                Integer value = Integer.valueOf(st.nextToken());
                if (hashMap.get(value) == true) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
```
4. command가 "empty"일 경우 모두 value가 false인 hashMap으로 변경, "all"일 경우 모두 true인 hashMap으로 변경

## :black_nib: **Review**
- 너무 안돼서 왜 안되지했더니 또 stringbuilder....
- 별의별짓 다하다가 했더니 이상한 코드 완성
- 이 문제에서 헤맨 덕에 20920에서 덜 헤매ㅁ.. 

## 📡 Link
https://www.acmicpc.net/problem/11723
